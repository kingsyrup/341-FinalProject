package GUI;

import static GUI.OverworldController.location;
import static Game.GameBoard.hero;
import static Game.GameBoard.items;
import static Game.GameBoard.visitCount;
import Interfaces.ItemInterface;
import NPCs.Enemy;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TownController implements Initializable {

    @FXML
    private Label output;
    
    @FXML
    private RadioButton radio1;
    
    @FXML
    private RadioButton radio2;
    
    @FXML
    private RadioButton radio3;
    
    @FXML
    private ToggleGroup group = new ToggleGroup();
    
    @FXML
    private AnchorPane backgroundPane;
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private Button eventButton;
    
    public static String decision;
    
    public static Enemy enemy;

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
    public void previous(ActionEvent event) throws IOException{
        if (location.name().equals("Ghenki City")){
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Overworld.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Overworld");

            window.setScene(tableViewScene);
            window.setResizable(false);
            window.show();
        }
        else{
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Game");

            window.setScene(tableViewScene);
            window.setResizable(false);
            window.show();
        }
        
    }
    
    @FXML
    public void event(ActionEvent event) throws IOException{
        textArea.appendText(decision);
        
        if(location.name().equals("Ghenki City")){
            if(radio1.isSelected()){
                if (hero.getHp() < hero.maxHp() + 50) {
                        hero.setHp(hero.getHp() + 50);
                        radio1.setDisable(true);
                        textArea.appendText("You feel a renewed sense of purpose, your "
                        + "health has been temporarily increased!\n");
                }
            }
            else if(radio2.isSelected()){
                 if (hero.getHp() < hero.maxHp()) {
                        hero.setHp(hero.maxHp());
                 }
            }
            else{
                if (visitCount == 10){
                    textArea.appendText("You sit next to the man in silence until"
                                + " at last he draws a breath and says, \"You "
                                + "seem to have trouble leaving this place"
                                + ".  Perhaps this will help.\"\n\n");
                        textArea.appendText("You receive a strange-looking sword.\n\n");
                        ArrayList<ItemInterface> imbaSword = items.tier(100);
                        hero.addToInventory(imbaSword.get(0));
                        visitCount++;
                }
                else{
                    visitCount++;
                }
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eventButton.disableProperty().bind(Bindings.createBooleanBinding(() -> {
            if(radio1.isDisabled() && radio1.isSelected()){
                return true;
            }
            return false;
        }, radio1.disableProperty(), radio1.selectedProperty()));
        radio1.setDisable(false); 
        if(location.name().equals("Ghenki City")){
            
            //set Location label
            output.setText(location.name());
        
            radio1.setText("Pray in the chapel");
            radio1.setUserData("You pray in the chapel.\n");
                
            radio2.setText("Spend the night in the inn");
            radio2.setUserData("You feel well rested.  Your health has been"
                                + " restored.\n");
            radio3.setText("Relax by the fountain in the city square");
            radio3.setUserData("You sit down on a bench next to a "
                                + "silvered-hair man.  You attempt to start a "
                                + "conversation with him, but he seems to ignore you.\n\n");
        }
        
        setBackground(); 
        
        //Toggle Group listener
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (group.getSelectedToggle() != null) {

                    decision = (String)group.getSelectedToggle().getUserData();
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
