/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static Game.GameBoard.hero;
import static Game.GameBoard.locations;
import static Game.GameBoard.multiplier;
import Interfaces.LocationInterface;
import Locations.FinalArea;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.collections.ObservableList;

/**
 *
 * @author Ajay
 */
public class OverworldController implements Initializable, Serializable {

    @FXML
    private ListView<LocationInterface> locationListView;

    @FXML
    private Button travelButton = new Button("Button -> Prop");

    @FXML
    private Label keyLabel;

    //used to reference single location
    public static LocationInterface location;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //add final area if 7 keys have been found
        if ((multiplier - 1) >= 7 && locations.size() != 9) {
            locations.add(new FinalArea());
        }

        ObservableList<LocationInterface> locationObservableList = FXCollections.observableList(locations);

        locationListView.setItems(locationObservableList);

        //populate list view
        locationListView.setCellFactory(lv -> new ListCell<LocationInterface>() {

            public void updateItem(LocationInterface c, boolean empty) {
                super.updateItem(c, empty);
                if (empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(c.name());
                    //if location has been visited, color background of cell
                    if(!c.name().equals("Ghenki City")  && !c.name().equals("Tower of Halvabor")){
                        if (c.getEvents().get(0).getEnemy().isKilled() &&
                            c.getEvents().get(1).getEnemy().isKilled() && 
                            c.getEvents().get(2).getEnemy().isKilled()) {
                            setDisable(true);
                            setStyle("-fx-background-color: #FA8304");
                        } else {
                            setStyle("");
                            setDisable(false);
                        }
                    }
                }
            }
        });

        //disable travel button until selection has been made
        travelButton.disableProperty().bind(locationListView.getSelectionModel().selectedItemProperty().isNull());

        //keep track of keys
        keyLabel.setText(" " + (multiplier - 1) + " / 7");

    }

    //check if saved?
    @FXML
    public void returnToMainMenu(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Main Menu");

        window.setScene(tableViewScene);
        window.show();
    }

    //only available after all keys are found
    @FXML
    public void travel(ActionEvent event) throws IOException {
        for (LocationInterface l : locations) {
            if (l == (locationListView.getSelectionModel().getSelectedItem())) {
                location = l;
            }
        }

        if(!location.name().equals("Tower of Halvabor")){
            loadLocation(event);
        }
        else{
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Combat.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Tower of Halvabor");

            window.setScene(tableViewScene);
            window.show();
        }
    }

    @FXML
    public void loadLocation(ActionEvent event) throws IOException {
        if(!"Ghenki City".equals(location.name())){
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Game");

        window.setScene(tableViewScene);
        window.show();
        }
        else{
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Town.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Ghenki City");

            window.setScene(tableViewScene);
            window.show();
        }
    }

    @FXML
    public void characterSheet(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Character.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Character Modification");

        window.setResizable(false);
        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    public void saveGame(ActionEvent event) throws IOException {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Hero.txt"));
            out.writeObject(hero);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
