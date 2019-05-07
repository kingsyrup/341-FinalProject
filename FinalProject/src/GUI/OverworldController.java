package GUI;

import static Game.GameBoard.locations;
import static Game.GameBoard.multiplier;
import Interfaces.LocationInterface;
import Locations.FinalArea;
import java.io.IOException;
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
 * The OverworldContoller is the view controller responsible for handling the 
 * actions of the Overworld.fxml GUI.
 * @author Ajay Basnyat, Erik Bjorngaard
 */
public class OverworldController implements Initializable {

    @FXML
    private ListView<LocationInterface> locationListView;

    @FXML
    private Button travelButton = new Button("Button -> Prop");

    @FXML
    private Label keyLabel;

    /**
     * The selected location, available in a global scope.
     */
    public static LocationInterface location;

    /**
     * Initialize the overworld screen when it has been loaded into memory.
     * @param url The location used to resolve relative paths for the root object, 
     * or null if the location is not known.
     * @param rb The resources used to localize the root object, or null if the 
     * root object was not localized.
     */
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

            //disable item in listview if nothing more can be done at that location
            public void updateItem(LocationInterface c, boolean empty) {
                super.updateItem(c, empty);
                if (empty) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(c.name());
                    //if location has been disabled, color background of cell
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

    /**
     * Return to the main menu screen when the return to main menu button is clicked.
     * @param event A new ActionEvent with an event type of ACTION.
     * @throws IOException if specified FXML resource cannot be loaded.
     * @ensure The main menu screen is displayed when the return to main menu
     * button is clicked.
     */
    @FXML
    public void returnToMainMenu(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Main Menu");

        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * Loads the location event screen when the travel button is pressed
     * if the Tower of Halvabor location is not selected, otherwise; the combat
     * screen is displayed instead.
     * @param event A new ActionEvent with an event type of ACTION.
     * @throws IOException if specified FXML resource cannot be loaded.
     * @ensure The combat screen is displayed when the travel button is pressed
     * if the Tower of Halvabor is selected, otherwise; the location event
     * screen is displayed instead.
     */
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

    /**
     * Displays the location event screen.
     * @param event A new ActionEvent with an event type of ACTION.
     * @throws IOException if specified FXML resource cannot be loaded.
     * @ensure The location event screen is displayed.
     */
    @FXML
    public void loadLocation(ActionEvent event) throws IOException {

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Game");

        window.setScene(tableViewScene);
        window.show();

    }

    /**
     * Displays the character sheet screen.
     * @param event A new ActionEvent with an event type of ACTION.
     * @throws IOException if specified FXML resource cannot be loaded.
     * @ensure The character sheet screen is displayed.
     */
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
