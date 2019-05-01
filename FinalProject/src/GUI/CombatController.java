package GUI;

import static GUI.GameController.decision;
import static Game.GameBoard.hero;
import static Game.GameBoard.items;
import static Game.Combat.chance;
import static Game.GameBoard.multiplier;
import Interfaces.ItemInterface;
import Interfaces.NpcInterface;
import NPCs.Enemy;
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
import javafx.scene.layout.Pane;
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
    
    @FXML
    private Pane enemyPane;
    
    private Enemy enemy;
    private int maxHp;
    private String description;
    private boolean hasKey;
    
    public CombatController(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        parseEvent();

        //name 
        playerLabel.setText(hero.getName());
        enemyLabel.setText(enemy.getName());
        
        //set enemy image
        setBackground();

        //health bar
        healthBar(hero);
        healthBar(enemy);
        
        combatTextArea.appendText(description + "\n");
        
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
            width = (((float)npc.getHp() / (float)maxHp) * 277);
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
            enemyHealthLabel.setText(String.valueOf(npc.getHp()) + "/" + String.valueOf(maxHp));
            
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
                
                if(hasKey){
                    combatTextArea.appendText("\nYou found a key.");
                    multiplier++;
                    decision.hasKey(false);
                }
            }
    }
    
    @FXML
    public void flee(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Game");

            window.setScene(tableViewScene);
            window.setResizable(false);
            window.show();
    }
    
    
    public void appendMessage(String message) {
        combatTextArea.appendText(message);
    }
    
    public void setBackground(){
        
        enemyPane.getStyleClass().clear();
        
        //set enemy background image
        if(enemy.getName().equals("Cyclops")){
            enemyPane.getStyleClass().add("cyclops");
        }
        
        if(enemy.getName().equals("Dragon")){
            enemyPane.getStyleClass().add("dragon");
        }
        
        if(enemy.getName().equals("Goblin")){
            enemyPane.getStyleClass().add("goblin");
        }
        
        if(enemy.getName().equals("Gryffin")){
            enemyPane.getStyleClass().add("gryffin");
        }
        
        if(enemy.getName().equals("Harpy")){
            enemyPane.getStyleClass().add("harpy");
        }
        
        if(enemy.getName().equals("Kobold")){
            enemyPane.getStyleClass().add("kobold");
        }
        
        if(enemy.getName().equals("Minotaur")){
            enemyPane.getStyleClass().add("minotaur");
        }
        
        if(enemy.getName().equals("Ogre")){
            enemyPane.getStyleClass().add("ogre");
        }
        
        if(enemy.getName().equals("Slime")){
            enemyPane.getStyleClass().add("slime");
        }
        
        if(enemy.getName().equals("Troll")){
            enemyPane.getStyleClass().add("troll");
        }
        
        if(enemy.getName().equals("Unicorn")){
            enemyPane.getStyleClass().add("unicorn");
        }
        
        if(enemy.getName().equals("Vampire")){
            enemyPane.getStyleClass().add("vampire");
        }
        
        if(enemy.getName().equals("Wraith")){
            enemyPane.getStyleClass().add("wraith");
        }
        
        if(enemy.getName().equals("Wyvern")){
            enemyPane.getStyleClass().add("wyvern");
        }
        
        if(enemy.getName().equals("Zombie")){
            enemyPane.getStyleClass().add("zombie");
        }
    }
    
    public void parseEvent(){
        description = decision.description();
        hasKey = decision.hasKey();
        enemy = decision.getEnemy();
        
        //apply multiplier - might need to rework this
        if(enemy.getHp() / multiplier != enemy.maxHp()){
            enemy.setDef(enemy.getDef() * multiplier);
            enemy.setStr(enemy.getStr() * multiplier);
            enemy.setHp(enemy.getHp() * multiplier); 
        }
        
        maxHp = enemy.maxHp() * multiplier;
    }
}
