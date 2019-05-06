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

public class GameSetupController implements Initializable {

    @FXML
    private TextField nameInput;
    @FXML
    private Label statusLabel;
    @FXML
    private Label startGame;
    @FXML
    private Label mainMenu;

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

    @FXML
    public void returnToMainMenu(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.setTitle("Main Menu");

        window.show();
    }

    public void enlargeStart() {
        startGame.setStyle("-fx-font: 42 System;");
    }

    public void shrinkStart() {
        startGame.setStyle("-fx-font: 32 System;");
    }

    public void enlargeMenu() {
        mainMenu.setStyle("-fx-font: 42 System;");
    }

    public void shrinkMenu() {
        mainMenu.setStyle("-fx-font: 32 System;");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameInput.setOnKeyTyped(event -> {
            String string = nameInput.getText();

            if (string.length() > 8) {
                nameInput.setText(string.substring(0, 8));
                nameInput.positionCaret(string.length());
            }

        });
    }
}
