package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is a simple RPG in which the player must find 7 keys to unlock the door
 * to the final area.  The player must then defeat the boss in the final area to
 * win the game.  Along the way, the player will fight monsters that may drop
 * items that the player can equip to aid them in their quest.
 * @author Ajay Basnyat, Erik Bjorngaard
 */
public class MainApplication extends Application {

    /**
     * Display the main menu screen when the application is launched.
     * @param primaryStage The primary stage of the application.
     * @throws Exception if specified FXML resource cannot be loaded.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Launch the application with the specified arguments.
     * @param args The user specified arguments that are used to modify how the
     * application is launched.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
