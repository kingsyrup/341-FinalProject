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
 * FXML Controller class
 * The GameOverContoller is the view controller responsible for handling the 
 * actions of the GameOver.fxml GUI.
 * @author Ajay Basnyat, Erik Bjorngaard
 */
public class GameOverController {

    @FXML
    private Label newGame;
    @FXML
    private Label mainMenu;
    @FXML
    private Label exit;
    
    @FXML
    private void startNewGame(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GameSetup.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Game Setup");
        
        window.setScene(tableViewScene);
        window.show();
    }
    
    @FXML
    private void returnToMenu(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.setTitle("Main Menu");
            
            window.show();
    }
    
    @FXML
    private void exit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void shrinkStart(MouseEvent event) {
        newGame.setStyle("-fx-font: 32 System;");
    }

    @FXML
    private void enlargeStart(MouseEvent event) {
        newGame.setStyle("-fx-font: 42 System;");
    }
    
    @FXML
    private void shrinkMenu(MouseEvent event) {
        mainMenu.setStyle("-fx-font: 32 System;");
    }

    @FXML
    private void enlargeMenu(MouseEvent event) {
        mainMenu.setStyle("-fx-font: 42 System;");
    }
    
    @FXML
    private void shrinkExit(MouseEvent event) {
        exit.setStyle("-fx-font: 32 System;");
    }

    @FXML
    private void enlargeExit(MouseEvent event) {
        exit.setStyle("-fx-font: 42 System;");
    }
}
