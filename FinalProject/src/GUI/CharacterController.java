package GUI;

import static Game.GameBoard.hero;
import static Game.GameBoard.items;
import Interfaces.ItemInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CharacterController implements Initializable {

    @FXML
    private Label nameLabel;

    @FXML
    private Rectangle healthBar;

    @FXML
    private Label healthBarLabel;

    @FXML
    private Label hpLabel;

    @FXML
    private Label strLabel;

    @FXML
    private Label defLabel;

    @FXML
    private Label hpDiffLabel;

    @FXML
    private Label strDiffLabel;

    @FXML
    private Label defDiffLabel;

    @FXML
    private TableView<ItemInterface> inventoryTable;

    @FXML
    private TableColumn<ItemInterface, String> nameColumn;

    @FXML
    private TableColumn<ItemInterface, String> typeColumn;

    @FXML
    private Button equipButton;

    private ObservableList<ItemInterface> inventory = FXCollections.observableArrayList();

    public void previous(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Overworld.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Overworld");

        window.setScene(tableViewScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        inventory = FXCollections.observableArrayList(hero.inventory);

        nameLabel.setText(hero.getName());
        hpLabel.setText(String.valueOf(hero.getHp()));
        strLabel.setText(String.valueOf(hero.getStr()));
        defLabel.setText(String.valueOf(hero.getDef()));

        nameColumn.setCellValueFactory(new PropertyValueFactory<ItemInterface, String>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<ItemInterface, String>("type"));
        inventoryTable.setItems(FXCollections.observableArrayList(inventory));

        //track currently equipped armor and weapon by marking table cell backgrounds green
        nameColumn.setCellFactory(column -> {
            return new TableCell<ItemInterface, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    setText(empty ? "" : getItem().toString());
                    setGraphic(null);

                    TableRow<ItemInterface> currentRow = getTableRow();

                    if (!isEmpty()) {
                        
                        if (hero.armorEquipped()) {
                            if (item.equals(hero.getEquippedArmor().getName())) {
                                currentRow.setStyle("-fx-background-color: #0fab9e");
                            }
                        }
                        if (hero.weaponEquipped()) {
                                if (item.equals(hero.getEquippedWeapon().getName())) {
                                    currentRow.setStyle("-fx-background-color: #0fab9e");
                                }
                        }
                        if (!hero.armorEquipped() && !hero.weaponEquipped()){
                            currentRow.setStyle("");
                        }
                    }
                }
            };
        });

        //bind item stats to diff labels
        inventoryTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {

                int equipHp = 0;
                int equipDef = 0;
                int equipStr = 0;

                if (newSelection.getType().equals("Armor")) {
                    if (hero.getEquippedArmor() != null) {
                        equipHp = hero.getEquippedArmor().getHpModifier();
                        equipDef = hero.getEquippedArmor().getDefModifier();
                        equipStr = hero.getEquippedArmor().getStrModifier();
                        if (inventoryTable.getSelectionModel().getSelectedItem().getName().equals(hero.getEquippedArmor().getName())) {
                            equipButton.setText("Unequip");
                        } else {
                            equipButton.setText("Equip");
                        }
                    } else {
                        equipButton.setText("Equip");
                    }

                } else {
                    if (hero.getEquippedWeapon() != null) {
                        equipHp = hero.getEquippedWeapon().getHpModifier();
                        equipDef = hero.getEquippedWeapon().getDefModifier();
                        equipStr = hero.getEquippedWeapon().getStrModifier();

                        if (inventoryTable.getSelectionModel().getSelectedItem().getName().equals(hero.getEquippedWeapon().getName())) {
                            equipButton.setText("Unequip");
                        } else {
                            equipButton.setText("Equip");
                        }
                    } else {
                        equipButton.setText("Equip");
                    }
                }

                int hpDiff = inventoryTable.getSelectionModel().getSelectedItem().getHpModifier() - equipHp;
                int strDiff = inventoryTable.getSelectionModel().getSelectedItem().getStrModifier() - equipStr;
                int defDiff = inventoryTable.getSelectionModel().getSelectedItem().getDefModifier() - equipDef;

                if (hpDiff < 0) {
                    hpDiffLabel.setTextFill(Color.RED);
                    hpDiffLabel.setText(String.valueOf(hpDiff));
                } else if (hpDiff > 0) {
                    hpDiffLabel.setTextFill(Color.GREEN);
                    hpDiffLabel.setText("+" + String.valueOf(hpDiff));
                } else {
                    hpDiffLabel.setText("");
                }

                if (strDiff < 0) {
                    strDiffLabel.setTextFill(Color.RED);
                    strDiffLabel.setText(String.valueOf(strDiff));
                } else if (strDiff > 0) {
                    strDiffLabel.setTextFill(Color.GREEN);
                    strDiffLabel.setText("+" + String.valueOf(strDiff));
                } else {
                    strDiffLabel.setText("");
                }

                if (defDiff < 0) {
                    defDiffLabel.setTextFill(Color.RED);
                    defDiffLabel.setText(String.valueOf(defDiff));
                } else if (defDiff > 0) {
                    defDiffLabel.setTextFill(Color.GREEN);
                    defDiffLabel.setText("+" + String.valueOf(defDiff));
                } else {
                    defDiffLabel.setText("");
                }
            }
        }); //end listener

        //health bar
        healthBar();
    }

    public void equip(ActionEvent event) {
        if (equipButton.getText().equals("Equip")) {
            hero.equipItem(inventoryTable.getSelectionModel().getSelectedItem());
            equipButton.setText("Unequip");
            defDiffLabel.setText("");
            hpDiffLabel.setText("");
            strDiffLabel.setText("");
        } else {
            hero.unequipItem(inventoryTable.getSelectionModel().getSelectedItem());
            equipButton.setText("Equip");
            if (inventoryTable.getSelectionModel().getSelectedItem().getDefModifier() > 0) {
                defDiffLabel.setTextFill(Color.GREEN);
                defDiffLabel.setText("+" + String.valueOf(inventoryTable.getSelectionModel().getSelectedItem().getDefModifier()));
            }
            if (inventoryTable.getSelectionModel().getSelectedItem().getHpModifier() > 0) {
                hpDiffLabel.setTextFill(Color.GREEN);
                hpDiffLabel.setText("+" + String.valueOf(inventoryTable.getSelectionModel().getSelectedItem().getHpModifier()));
            }
            if (inventoryTable.getSelectionModel().getSelectedItem().getStrModifier() > 0) {
                strDiffLabel.setTextFill(Color.GREEN);
                strDiffLabel.setText("+" + String.valueOf(inventoryTable.getSelectionModel().getSelectedItem().getStrModifier()));
            }
        }

        strLabel.setText(String.valueOf(hero.getStr()));
        defLabel.setText(String.valueOf(hero.getDef()));
        hpLabel.setText(String.valueOf(hero.getHp()));
        healthBar();

        //track currently equipped armor and weapon by marking table cell backgrounds green
        nameColumn.setCellFactory(column -> {
            return new TableCell<ItemInterface, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    setText(empty ? "" : getItem().toString());
                    setGraphic(null);

                    TableRow<ItemInterface> currentRow = getTableRow();

                    if (!isEmpty()) {
                        
                        if (hero.armorEquipped()) {
                            if (item.equals(hero.getEquippedArmor().getName())) {
                                currentRow.setStyle("-fx-background-color: #0fab9e");
                            }
                        }
                        if (hero.weaponEquipped()) {
                                if (item.equals(hero.getEquippedWeapon().getName())) {
                                    currentRow.setStyle("-fx-background-color: #0fab9e");
                                }
                        }
                        if (!hero.armorEquipped() && !hero.weaponEquipped()){
                            currentRow.setStyle("");
                        }
                    }
                }
            };
        });
    }

    public void healthBar() {
        //health bar
        float percentage = ((float) hero.getHp() / (float) hero.maxHp());
        float width = (percentage * 411);
        healthBar.setWidth(width);
        if (percentage >= 0.5) {
            healthBar.setFill(Color.web("#34da3c"));
        } else if (percentage >= 0.25 && percentage < 0.5) {
            healthBar.setFill(Color.YELLOW);
        } else {
            healthBar.setFill(Color.RED);
        }
        healthBarLabel.setText(String.valueOf(hero.getHp()) + "/" + String.valueOf(hero.maxHp()));
    }
}
