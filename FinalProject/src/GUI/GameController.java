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

import static GUI.OverworldController.location;
import static Game.GameBoard.hero;
import static Game.GameBoard.items;
import static Game.GameBoard.visitCount;
import Interfaces.EventInterface;
import Interfaces.ItemInterface;
import NPCs.Enemy;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 * The GameContoller is the view controller responsible for handling the 
 * actions of the Game.fxml GUI.
 * @author Ajay Basnyat, Erik Bjorngaard
 */
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

    @FXML
    private Rectangle textBackground;

    @FXML
    private Label textLabel;
    
    @FXML
    private Label descriptionLabel;

    @FXML
    private ToggleGroup group = new ToggleGroup();

    @FXML
    private AnchorPane backgroundPane;

    @FXML
    private ImageView swordImg;

    /**
     * The event that has been chosen.
     */
    public static EventInterface decision;

    /**
     * The enemy that is to be battled.
     */
    public static Enemy enemy;

    private FadeTransition fadeInSword = new FadeTransition(
            Duration.millis(5000)
    );

    /**
     * Return to the overworld screen when the return previous screen button is clicked.
     * @param event A new ActionEvent with an event type of ACTION.
     * @throws IOException if specified FXML resource cannot be loaded.
     * @ensure The overworld screen is displayed when the return to previous screen
     * button is clicked.
     */
    @FXML
    public void previous(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Overworld.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Overworld");

        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }

    /**
     * Display the combat screen for the selected event.  If the location is Ghenki
     * City, display text for the selected event instead.
     * @param event A new ActionEvent with an event type of ACTION.
     * @throws IOException if specified FXML resource cannot be loaded.
     * @ensure The Combat screen is displayed for the selected event, unless 
     * Ghenki City is the location.  If Ghenki City is the location, text is displayed.
     */
    @FXML
    public void event(ActionEvent event) throws IOException {
        //custom action for city scene which has unique events
        if (location.name().equals("Ghenki City")) {
            textLabel.setVisible(true);
            textBackground.setVisible(true);

            if (radio1.isSelected()) {
                if (hero.getHp() < hero.maxHp() + 50) {
                    hero.setHp(hero.getHp() + 50);
                    radio1.setDisable(true);
                    textLabel.setText("You feel a renewed sense of purpose, your "
                            + "health has been temporarily increased!\n");
                }
            } else if (radio2.isSelected()) {
                if (hero.getHp() < hero.maxHp()) {
                    hero.setHp(hero.maxHp());
                }
                textLabel.setText("You feel well rested.  Your health has been restored.");
            } else {
                if (visitCount == 10) {
                    textLabel.setText("You sit next to the man in silence until"
                            + " at last he draws a breath and says, \"You "
                            + "seem to \nhave trouble leaving this place"
                            + ".  Perhaps this will help.\"");
                    ArrayList<ItemInterface> imbaSword = items.tier(100);
                    hero.addToInventory(imbaSword.get(0));
                    visitCount++;

                    swordImg.setVisible(true);
                    fadeInSword.playFromStart();
                } else {
                    textLabel.setText("You sit down on a bench next to a "
                            + "silvered-hair man.  You attempt to start a "
                            + "\nconversation with him, but he seems to ignore you.");
                    visitCount++;
                }
            }

        } //selection button action for all other locations which leads to combat scene
        else {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Combat.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Combat");

            window.setScene(tableViewScene);
            window.setResizable(false);
            window.show();
        }
    }

    /**
     * Initialize the location event screen when it has been loaded into memory.
     * @param url The location used to resolve relative paths for the root object, 
     * or null if the location is not known.
     * @param rb The resources used to localize the root object, or null if the 
     * root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set Location label
        output.setText(location.name());

        //custom choices for city which has unique events
        if (location.name().equals("Ghenki City")) {

            eventButton.disableProperty().bind(Bindings.createBooleanBinding(() -> {
                if (radio1.isDisabled() && radio1.isSelected()) {
                    return true;
                }
                return false;
            }, radio1.disableProperty(), radio1.selectedProperty()));
            radio1.setDisable(false);

            radio1.setText("Pray in the chapel");

            radio2.setText("Spend the night in the inn");

            radio3.setText("Relax by the fountain in the city square");

            //sword animations
            fadeInSword.setNode(swordImg);
            fadeInSword.setFromValue(0.0);
            fadeInSword.setToValue(1.0);

            fadeInSword.setOnFinished((e) -> {
                FadeTransition fadeOutSword = new FadeTransition(
                        Duration.millis(5000)
                );
                fadeOutSword.setNode(swordImg);
                fadeOutSword.setFromValue(1.0);
                fadeOutSword.setToValue(0.0);
                fadeOutSword.play();
            });

        } //setup for all other locations
        else {

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
                if ((radio1.isDisabled() && radio1.isSelected()) || (radio2.isDisabled()
                        && radio2.isSelected()) || (radio3.isDisabled()
                        && radio3.isSelected()) || (radio1.isDisabled()
                        && radio2.isDisabled() && radio3.isDisabled())
                        || (!radio1.isSelected() && !radio2.isSelected() && !radio3.isSelected())) {
                    return true;
                }
                return false;
            }, radio1.disableProperty(), radio1.selectedProperty(), radio2.disableProperty(),
                    radio2.selectedProperty(), radio3.disableProperty(), radio3.selectedProperty()));
        }

        //Toggle Group listener
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

                if (group.getSelectedToggle() != null) {

                    decision = (EventInterface) group.getSelectedToggle().getUserData();
                }
            }
        });

        setBackground();
        descriptionLabel.setText(location.description());
        
    }

    /**
     * Sets the background image dependent on the location.
     * @ensure The background image is set.
     */
    public void setBackground() {
        //set background image
        backgroundPane.getStyleClass().clear();

        if (location.name().equals("Weisgrow Forest")) {
            backgroundPane.getStyleClass().add("forest");
        }

        if (location.name().equals("Frostburn Tundra")) {
            backgroundPane.getStyleClass().add("tundra");
        }

        if (location.name().equals("Brackmire Marsh")) {
            backgroundPane.getStyleClass().add("marsh");
        }

        if (location.name().equals("Kulpaki Desert")) {
            backgroundPane.getStyleClass().add("desert");
        }

        if (location.name().equals("Dashuk Mountains")) {
            backgroundPane.getStyleClass().add("mountain");
        }

        if (location.name().equals("Golbrow Plains")) {
            backgroundPane.getStyleClass().add("plains");
        }

        if (location.name().equals("Deepholm Mines")) {
            backgroundPane.getStyleClass().add("mines");
        }

        if (location.name().equals("Ghenki City")) {
            backgroundPane.getStyleClass().add("town");
        }

        if (location.name().equals("Tower of Halvabor")) {
            backgroundPane.getStyleClass().add("tower");
        }
    }
}
