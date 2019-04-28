package GUI;

import static GUI.OverworldController.location;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.TextFlow;
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
    ToggleGroup group = new ToggleGroup();

    public void radio1Click() {
        //event1
    }
    public void radio2Click() {
        //event2
    }
    public void radio3Click() {
        //event3
    }

    public void previous(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Overworld.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        output.setText(location.name());
        radio1.setText(location.getEvents().get(0).name());
        radio2.setText(location.getEvents().get(1).name());
        radio3.setText(location.getEvents().get(2).name());
    }
}
