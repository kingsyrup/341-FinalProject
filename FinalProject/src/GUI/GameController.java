package GUI;

import static GUI.OverworldController.location;
import Interfaces.EventInterface;
import NPCs.Enemy;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameController implements Initializable {

    @FXML
    private Label output;
    
    @FXML
    private RadioButton radio1;
    
    @FXML
    private RadioButton radio2;
    
    @FXML
    private RadioButton radio3;
    
    @FXML
    private Button eventButton;
    
    public void radio1Click() {
        //event1
    }
    public void radio2Click() {
        //event2
    }
    public void radio3Click() {
        //event3
    }
    
    @FXML
    private ToggleGroup group = new ToggleGroup();
    
    @FXML
    private AnchorPane backgroundPane;
    
    public static EventInterface decision;
    
    public static Enemy enemy;

    @FXML
    public void previous(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Overworld.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Overworld");

            window.setScene(tableViewScene);
            window.setResizable(false);
            window.show();
    }
    
    @FXML
    public void event(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Combat.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Combat");

            window.setScene(tableViewScene);
            window.setResizable(false);
            window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set Location label
        output.setText(location.name());
        
        //initialze radio buttons
        radio1.setUserData(location.getEvents().get(0));
        radio1.setText(location.getEvents().get(0).name());
        radio2.setUserData(location.getEvents().get(1));
        radio2.setText(location.getEvents().get(1).name());
        radio3.setUserData(location.getEvents().get(2));
        radio3.setText(location.getEvents().get(2).name());
        
        radio1.disableProperty().bind(Bindings.createBooleanBinding(() -> {
            return location.getEvents().get(0).getEnemy().isKilled();
        }));
        
        radio2.disableProperty().bind(Bindings.createBooleanBinding(() -> {
            return location.getEvents().get(1).getEnemy().isKilled();
        }));
        
        radio3.disableProperty().bind(Bindings.createBooleanBinding(() -> {
            return location.getEvents().get(2).getEnemy().isKilled();
        }));
        
        eventButton.disableProperty().bind(Bindings.createBooleanBinding(() -> {
            if((radio1.isDisabled() && radio1.isSelected()) || (radio2.isDisabled() 
                    && radio2.isSelected()) || (radio3.isDisabled() 
                    && radio3.isSelected())|| (radio1.isDisabled() 
                    && radio2.isDisabled() && radio3.isDisabled()) || 
                    (!radio1.isSelected() && !radio2.isSelected() && !radio3.isSelected())){
                return true;
            }
            return false;
        }, radio1.disableProperty(), radio1.selectedProperty(), radio2.disableProperty(), 
            radio2.selectedProperty(), radio3.disableProperty(), radio3.selectedProperty()));
        
        setBackground(); 
        
        //Toggle Group listener
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (group.getSelectedToggle() != null) {

                    decision = (EventInterface)group.getSelectedToggle().getUserData();
                }

            } 
        });
    }
    
    public void setBackground(){
        //set background image
        backgroundPane.getStyleClass().clear();
        
        if(location.name().equals("Weisgrow Forest")){
            backgroundPane.getStyleClass().add("forest");
        }
        
        if(location.name().equals("Frostburn Tundra")){
            backgroundPane.getStyleClass().add("tundra");
        }
        
        if(location.name().equals("Brackmire Marsh")){
            backgroundPane.getStyleClass().add("marsh");
        }
        
        if(location.name().equals("Kulpaki Desert")){
            backgroundPane.getStyleClass().add("desert");
        }
        
        if(location.name().equals("Dashuk Mountains")){
            backgroundPane.getStyleClass().add("mountain");
        }
        
        if(location.name().equals("Golbrow Plains")){
            backgroundPane.getStyleClass().add("plains");
        }
        
        if(location.name().equals("Deepholm Mines")){
            backgroundPane.getStyleClass().add("mines");
        }
        
        if(location.name().equals("Ghenki City")){
            backgroundPane.getStyleClass().add("town");
        }  
        
        if(location.name().equals("Tower of Halvabor")){
            backgroundPane.getStyleClass().add("tower");
        } 
    }
}
