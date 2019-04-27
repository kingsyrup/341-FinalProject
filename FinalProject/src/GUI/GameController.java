package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.TextFlow;

public class GameController implements Initializable {

    @FXML
    private Label output;
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    ToggleGroup group = new ToggleGroup();

    public void radio1Click() {
        output.setText("radio1");
    }
    public void radio2Click() {
        output.setText("radio2");
    }
    public void radio3Click() {
        output.setText("radio3");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
