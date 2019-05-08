/**
 * @author Ajay Basnyat and Erik Bjorngaard
 * @version 5/7/2019
 *
 * Course: CS341 - Data Structures
 *
 * Assignment: Final Project 
 *
 * Purpose: GUI Controller class to be used with corresponding .fxml file 
 * 
 * Implements Initializable
 */

package GUI;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * The MainMenuContoller is the view controller responsible for handling the 
 * actions of the MainMenu.fxml GUI.
 * @author Ajay Basnyat, Erik Bjorngaard
 */
public class MainMenuController {

    @FXML
    private Label newGame;

    @FXML
    private Label exit;

    /**
     * Display the game setup screen when the start game label is clicked.
     * @param event A new ActionEvent with an event type of ACTION.
     * @throws IOException if specified FXML resource cannot be loaded.
     * @ensure The game setup screen is displayed.
     */
    @FXML
    public void startNewGame(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GameSetup.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Game Setup");

        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * Exit the application when the exit label is clicked.
     */
    public void exit() {
        System.exit(0);
    }

    /**
     * Enlarge the start label font when it comes into focus.
     */
    public void enlargeStart() {
        newGame.setStyle("-fx-font: 42 System;");
    }

    /**
     * Shrink the start label font when it is no longer in focus.
     */
    public void shrinkStart() {
        newGame.setStyle("-fx-font: 32 System;");
    }

    /**
     * Enlarge the exit label font when it comes into focus.
     */
    public void enlargeExit() {
        exit.setStyle("-fx-font: 42 System;");
    }

    /**
     * Shrink the exit label font when it is no longer in focus.
     */
    public void shrinkExit() {
        exit.setStyle("-fx-font: 32 System;");
    }
}
