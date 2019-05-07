package GUI;

import static Game.GameBoard.hero;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * The GameSetupContoller is the view controller responsible for handling the 
 * actions of the GameSetup.fxml GUI.
 * @author Ajay Basnyat, Erik Bjorngaard
 */
public class GameSetupController implements Initializable {

    @FXML
    private TextField nameInput;
    @FXML
    private Label statusLabel;
    @FXML
    private Label startGame;
    @FXML
    private Label mainMenu;

    /**
     * Displays the overworld screen when the start game label is clicked.
     * @param event A new ActionEvent with an event type of ACTION.
     * @throws IOException if specified FXML resource cannot be loaded.
     * @ensure The overworld screen is displayed when the start game label is clicked.
     */
    @FXML
    public void startGame(MouseEvent event) throws IOException {

        String heroName = nameInput.getText();

        Game.Initialize.init();

        if (heroName.length() == 0) {
            statusLabel.setText("Please enter a name in the text field.");
        } else {
            //initialize hero with name and default HP
            hero.setName(heroName);


            //start new game
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Overworld.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Overworld");

            window.setScene(tableViewScene);
            window.show();
        }
    }

    /**
     * Returns to the main menu when the main menu label is clicked.
     * @param event A new ActionEvent with an event type of ACTION.
     * @throws IOException if specified FXML resource cannot be loaded.
     * @ensure The main menu screen is displayed when the return to main menu
     * label is clicked.
     */
    @FXML
    public void returnToMainMenu(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setTitle("Main Menu");

        window.show();
    }

    /**
     * Enlarges the start label font when it comes into focus.
     */
    public void enlargeStart() {
        startGame.setStyle("-fx-font: 42 System;");
    }

    /**
     * Shrinks the start label font when it loses focus.
     */
    public void shrinkStart() {
        startGame.setStyle("-fx-font: 32 System;");
    }

    /**
     * Enlarges the menu label font when it comes into focus.
     */
    public void enlargeMenu() {
        mainMenu.setStyle("-fx-font: 42 System;");
    }

    /**
     * Shrinks the menu label font when it loses focus.
     */
    public void shrinkMenu() {
        mainMenu.setStyle("-fx-font: 32 System;");
    }

    /**
     * Initialize the game setup screen when it has been loaded into memory.
     * @param url The location used to resolve relative paths for the root object, 
     * or null if the location is not known.
     * @param rb The resources used to localize the root object, or null if the 
     * root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //limit the name length to 8 characters
        nameInput.setOnKeyTyped(event -> {
            String string = nameInput.getText();

            if (string.length() > 8) {
                nameInput.setText(string.substring(0, 8));
                nameInput.positionCaret(string.length());
            }

        });
    }
}
