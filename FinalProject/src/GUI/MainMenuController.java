package GUI;

import NPCs.Hero;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Ajay
 */
public class MainMenuController implements Initializable {

    @FXML
    private Label newGame;

    @FXML
    private Label loadGame;

    @FXML
    private Label exit;

    @FXML
    public void startNewGame(MouseEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("GameSetup.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Game Setup");

        window.setScene(tableViewScene);
        window.show();
    }

    public void loadGame(ActionEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {
        //load character data
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Hero.txt"));
        Hero hero = (Hero) in.readObject();
        in.close();

        //load overworld
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Overworld.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Overworld");

        window.setScene(tableViewScene);
        window.show();
    }

    public void exit() {
        System.exit(0);
    }

    public void enlargeStart() {
        newGame.setStyle("-fx-font: 42 System;");
    }

    public void shrinkStart() {
        newGame.setStyle("-fx-font: 32 System;");
    }

    public void enlargeLoad() {
        loadGame.setStyle("-fx-font: 42 System;");
    }

    public void shrinkLoad() {
        loadGame.setStyle("-fx-font: 32 System;");
    }

    public void enlargeExit() {
        exit.setStyle("-fx-font: 42 System;");
    }

    public void shrinkExit() {
        exit.setStyle("-fx-font: 32 System;");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
