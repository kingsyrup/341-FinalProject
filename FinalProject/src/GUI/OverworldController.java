/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static Game.GameBoard.locations;
import static Game.GameBoard.multiplier;
import Interfaces.LocationInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import java.util.ArrayList;

/**
 *
 * @author Ajay
 */
public class OverworldController implements Initializable {

    @FXML
    private ListView<String> locationListView;

    @FXML
    private Button travelButton = new Button("Button -> Prop");

    @FXML
    private Label keyLabel;

    private ArrayList<String> locationList = new ArrayList();

    private ListProperty<String> listProperty = new SimpleListProperty<>();

    public static LocationInterface location;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).visited()) {
                locationList.add(locations.get(i).name() + " (visited)");
            } else {
                locationList.add(locations.get(i).name());
            }
        }

        //locationListView.setItems(menu);
        locationListView.itemsProperty().bind(listProperty);
        listProperty.set(FXCollections.observableArrayList(locationList));
        travelButton.disableProperty().bind(locationListView.getSelectionModel().selectedItemProperty().isNull());

//        keyLabel.textProperty().bind(new SimpleIntegerProperty(multiplier - 1).asString());
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
            if (l.name().contains(locationListView.getSelectionModel().getSelectedItem())) {
                location = l;
            }
        }
        //mark that location has been traveled to
        location.visit();
        loadLocation(event);
    }

    @FXML
    public void loadLocation(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Game");

        window.setScene(tableViewScene);
        window.show();
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
}
