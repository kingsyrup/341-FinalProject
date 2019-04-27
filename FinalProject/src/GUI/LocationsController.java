/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ajay
 */
public class LocationsController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    //check if saved?
    @FXML
    public void returnToMainMenu(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
    
    @FXML
    public void toDesert(ActionEvent event) throws IOException {
        loadLocation(event);
    }
    
    @FXML
    public void toForest(ActionEvent event) throws IOException {
        loadLocation(event);
    }
    
    @FXML
    public void toMarsh(ActionEvent event) throws IOException {
        loadLocation(event);
    }
    
    @FXML
    public void toMines(ActionEvent event) throws IOException {
        loadLocation(event);
    }
    
    @FXML
    public void toPlains(ActionEvent event) throws IOException {
        loadLocation(event);
    }
    
    @FXML
    public void toTown(ActionEvent event) throws IOException {
        loadLocation(event);
    }
    
    @FXML
    public void toTundra(ActionEvent event) throws IOException {
        loadLocation(event);
    }
    
    @FXML
    public void toMountains(ActionEvent event) throws IOException {
        loadLocation(event);
    }
    
    //only available after all keys are found
    @FXML
    public void toFinalArea(ActionEvent event) throws IOException {
        loadLocation(event);
    }
    
    @FXML
    public void loadLocation(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

}
