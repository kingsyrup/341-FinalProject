package GUI;

import static Game.GameBoard.hero;
import static Game.GameBoard.items;
import static GUI.GameController.enemy;
import static Game.Combat.chance;
import static Game.GameBoard.multiplier;
import Interfaces.ItemInterface;
import Interfaces.NpcInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class CombatController implements Initializable {
    
    @FXML
    private Label playerLabel;

    @FXML
    private Rectangle playerHealthBar;

    @FXML
    private Label playerHealthLabel;

    @FXML
    private Rectangle enemyHealthBar;

    @FXML
    private Label enemyHealthLabel;
    
    @FXML
    private Label enemyLabel;
    
    @FXML
    private TextArea combatTextArea;
    
    @FXML
    private Button attackButton;
    
    private int baseHp = enemy.getHp();
    
    public CombatController(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //name 
        playerLabel.setText(hero.getName());
        enemyLabel.setText(enemy.getName());
        
        //apply multiplier - might need to rework this
        if (enemy.getHp() / multiplier != baseHp) {
            enemy.setDef(enemy.getDef() * multiplier);
            enemy.setStr(enemy.getStr() * multiplier);
            enemy.setHp(enemy.getHp() * multiplier);
        }
        
        //health bar
        healthBar(hero);
        healthBar(enemy);
        
        combatTextArea.appendText("You begin fighting the " + enemy.getName() + ".");
        
    }
    
    @FXML
    public void healthBar(NpcInterface npc){
        //health bar
        float percentage = ((float)npc.getHp() / (float)npc.maxHp());
        float width = (percentage * 277);
        if(npc.equals(hero)){
            playerHealthBar.setWidth(width);
            if(percentage >= 0.5){
                playerHealthBar.setFill(Color.web("#34da3c"));
            }
            else if(percentage >= 0.25 && percentage < 0.5){
                playerHealthBar.setFill(Color.YELLOW);
            }
            else{
                playerHealthBar.setFill(Color.RED);
            }
            playerHealthLabel.setText(String.valueOf(npc.getHp()) + "/" + String.valueOf(npc.maxHp()));
        }
        else{
             enemyHealthBar.setWidth(width);
            if(percentage >= 0.5){
                enemyHealthBar.setFill(Color.web("#34da3c"));
            }
            else if(percentage >= 0.25 && percentage < 0.5){
                enemyHealthBar.setFill(Color.YELLOW);
            }
            else{
                enemyHealthBar.setFill(Color.RED);
            }
            enemyHealthLabel.setText(String.valueOf(npc.getHp()) + "/" + String.valueOf(npc.maxHp()));
            
        }
    }
    
    @FXML
    public void attack(ActionEvent event) throws IOException{
        int damage = hero.attack(enemy);
        combatTextArea.appendText("\nYou dealt " + damage + " damage to the " + enemy.getName() + ".");
            if (!enemy.isKilled()) {
                damage = enemy.attack(hero);
                combatTextArea.appendText("\nThe " + enemy.getName() + " dealt " + damage + 
                " damage to the " + hero.getName() + ".\n");
            }
            healthBar(hero);
            healthBar(enemy);
            
            //enemy is dead
            if(enemy.isKilled()){
                combatTextArea.appendText("\nYou defeated the " + enemy.getName() + ".");
                attackButton.setDisable(true);

                if (chance(25)) {
                    //Enemy drops random item from current tier - based on difficulty multiplier
                    Random rng = new Random();
                    ArrayList<ItemInterface> loot = items.tier(multiplier);
                    int modifier = (rng.nextInt(loot.size()));
                    ItemInterface item = loot.get(modifier);

                    //Add item to player's inventory and remove from global item list
                    // ensures items are unique
                    hero.addToInventory(item);
                    combatTextArea.appendText("\nThe " + enemy.getName() + " dropped a " + item.getName()
                            + ".");
                    items.removeItem(item);
                }
            }
    }
    
    @FXML
    public void flee(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.setResizable(false);
            window.show();
    }
    
    
    public void appendMessage(String message) {
        combatTextArea.appendText(message);
    }
}
