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

import static GUI.GameController.decision;
import static GUI.OverworldController.location;
import static Game.GameBoard.hero;
import static Game.GameBoard.items;
import static Game.GameBoard.multiplier;
import Interfaces.ItemInterface;
import Interfaces.NpcInterface;
import NPCs.Enemy;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The CombatContoller is the view controller responsible for handling the 
 * actions of the Combat.fxml GUI.
 * @author Ajay Basnyat, Erik Bjorngaard
 */
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
    private Label itemDropLabel;
    
    @FXML
    private Label heroDamage;
    
    @FXML
    private Label enemyDamage;
    
    @FXML
    private Button attackButton;
    
    @FXML
    private Pane enemyPane;
    
    @FXML
    private Label keyLabel;
    
    @FXML
    private ImageView keyImage;
    
    @FXML
    private Label descriptionLabel;
    
    private Enemy enemy;
    private int maxHp;
    private boolean hasKey;

    //label fade transitions
    private FadeTransition fadeOutHeroDamage = new FadeTransition(
            Duration.millis(2000)
    );
    
    private FadeTransition fadeOutEnemyDamage = new FadeTransition(
            Duration.millis(2000)
    );
    
    private FadeTransition fadeOutEnemy = new FadeTransition(
            Duration.millis(2000)
    );
    
    /**
     * Initialize the combat screen when it has been loaded into memory.
     * @param url The location used to resolve relative paths for the root object, 
     * or null if the location is not known.
     * @param rb The resources used to localize the root object, or null if the 
     * root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //setup enemy
        parseEvent();

        attackButton.setDisable(enemy.isKilled());
        
        //name 
        playerLabel.setText(hero.getName());
        enemyLabel.setText(enemy.getName());

        //set enemy image
        setBackground();

        //health bar
        healthBar(hero);
        healthBar(enemy);
        
        fadeOutHeroDamage.setNode(heroDamage);
        fadeOutHeroDamage.setFromValue(1.0);
        fadeOutHeroDamage.setToValue(0.0);
        
        fadeOutEnemyDamage.setNode(enemyDamage);
        fadeOutEnemyDamage.setFromValue(1.0);
        fadeOutEnemyDamage.setToValue(0.0);
        
        fadeOutEnemy.setNode(enemyPane);
        fadeOutEnemy.setFromValue(1.0);
        fadeOutEnemy.setToValue(0.0);
    }
    
    /**
     * Shows the health bar for the specified character.  The health bar depletes
     * as hit points are lost.
     * @param npc Whose health bar should be shown.
     * @ensure The health bar is shown.  The health bar depletes as hit points are lost.
     */
    @FXML
    public void healthBar(NpcInterface npc) {
        //health bar
        float percentage = ((float) npc.getHp() / (float) npc.maxHp());
        float width = (percentage * 340);
        if (npc.equals(hero)) {
            if(percentage <= 1){
                playerHealthBar.setWidth(width);
                if (percentage >= 0.5) {
                    playerHealthBar.setFill(Color.web("#34da3c"));
                } else if (percentage >= 0.25 && percentage < 0.5) {
                    playerHealthBar.setFill(Color.YELLOW);
                } else {
                    playerHealthBar.setFill(Color.RED);
                }
            }
            else{
                playerHealthBar.setWidth(340);
                playerHealthBar.setFill(Color.web("#34da3c"));
            }
            playerHealthLabel.setText(String.valueOf(npc.getHp()) + "/" + String.valueOf(npc.maxHp()));
        } else {
            width = (((float) npc.getHp() / (float) maxHp) * 340);
            enemyHealthBar.setWidth(width);
            if (percentage >= 0.5) {
                enemyHealthBar.setFill(Color.web("#34da3c"));
            } else if (percentage >= 0.25 && percentage < 0.5) {
                enemyHealthBar.setFill(Color.YELLOW);
            } else {
                enemyHealthBar.setFill(Color.RED);
            }
            enemyHealthLabel.setText(String.valueOf(npc.getHp()) + "/" + String.valueOf(maxHp));
            
        }
    }
    
    /**
     * The player attacks the enemy, the enemy attacks back.
     * @param event A new ActionEvent with an event type of ACTION.
     * @throws IOException if specified FXML resource cannot be loaded.
     * @ensure The player attacks the enemy.
     */
    @FXML
    public void attack(ActionEvent event) throws IOException {
        int damage = hero.attack(enemy);
        enemyDamage.setText("-" + damage);
        fadeOutEnemyDamage.playFromStart();
        if (!enemy.isKilled()) {
            damage = enemy.attack(hero);
            heroDamage.setText("-" + damage);
            fadeOutHeroDamage.playFromStart();
        }
        healthBar(hero);
        healthBar(enemy);

        //enemy is dead
        if (enemy.isKilled()) {
            if(!enemy.getName().equals("Valjir")){
                attackButton.setDisable(true);
                fadeOutEnemy.playFromStart();

                if (chance(65)) {
                    //Enemy drops random item from current tier - based on difficulty multiplier
                    Random rng = new Random();
                    ArrayList<ItemInterface> loot = items.tier(multiplier);
                    if(loot.isEmpty()){
                        loot = items.tier(multiplier + 1);
                    }
                    int modifier = (rng.nextInt(loot.size()));
                    ItemInterface item = loot.get(modifier);

                    //Add item to player's inventory and remove from global item list
                    // ensures items are unique
                    hero.addToInventory(item);
                    items.removeItem(item);

                    itemDropLabel.setVisible(true);
                    itemDropLabel.setText("The " + enemy.getName() + " dropped a " + item.getName()
                            + ".");
                }
                //key is found
                if (hasKey) {
                    multiplier++;
                    decision.hasKey(false);

                    keyLabel.setVisible(true);
                    keyImage.setVisible(true);
                }
            }
            else{
                //game is won
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("GameWon.fxml"));
                Scene tableViewScene = new Scene(tableViewParent);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(tableViewScene);
                window.show();
            }
        }

        //hero is dead
        if (hero.isKilled()) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Game Over");
            window.setScene(tableViewScene);
            window.show();
        }
    }
    
    /**
     * Return to the location event screen when the flee button is clicked.
     * @param event A new ActionEvent with an event type of ACTION.
     * @throws IOException if specified FXML resource cannot be loaded.
     * @ensure The location event screen is displayed when the flee
     * button is clicked.
     */
    @FXML
    public void flee(ActionEvent event) throws IOException {
        if(!location.name().equals("Tower of Halvabor")){
            if(!enemy.isKilled()){
                enemy.setHp(enemy.maxHp());
            }
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Game.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Game");

            window.setScene(tableViewScene);
            window.setResizable(false);
            window.show();
        }
        else{
            descriptionLabel.setVisible(false);
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Overworld.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Overworld");

            window.setScene(tableViewScene);
            window.setResizable(false);
            window.show();
        }
    }
    
    /**
     * Sets the enemy image dependent on which enemy is being battled.
     * @ensure The enemy's image is set.
     */
    public void setBackground() {
        
        enemyPane.getStyleClass().clear();

        //set enemy background image
        if (enemy.getName().equals("Bandit")) {
            enemyPane.getStyleClass().add("bandit");
        }
        
        if (enemy.getName().equals("Cyclops")) {
            enemyPane.getStyleClass().add("cyclops");
        }
        
        if (enemy.getName().equals("Demon")) {
            enemyPane.getStyleClass().add("demon");
        }
        
        if (enemy.getName().equals("Dragon")) {
            enemyPane.getStyleClass().add("dragon");
        }
        
        if (enemy.getName().equals("Dwarf")) {
            enemyPane.getStyleClass().add("dwarf");
        }
        
        if (enemy.getName().equals("Elf")) {
            enemyPane.getStyleClass().add("elf");
        }
        
        if (enemy.getName().equals("Giant")) {
            enemyPane.getStyleClass().add("giant");
        }
        
        if (enemy.getName().equals("Goblin")) {
            enemyPane.getStyleClass().add("goblin");
        }
        
        if (enemy.getName().equals("Gryffin")) {
            enemyPane.getStyleClass().add("gryffin");
        }
        
        if (enemy.getName().equals("Harpy")) {
            enemyPane.getStyleClass().add("harpy");
        }
        
        if (enemy.getName().equals("Hydra")) {
            enemyPane.getStyleClass().add("hydra");
        }
        
        if (enemy.getName().equals("Kobold")) {
            enemyPane.getStyleClass().add("kobold");
        }
        
        if (enemy.getName().equals("Lich")) {
            enemyPane.getStyleClass().add("lich");
        }
        
        if (enemy.getName().equals("Medusa")) {
            enemyPane.getStyleClass().add("medusa");
        }
        
        if (enemy.getName().equals("Minotaur")) {
            enemyPane.getStyleClass().add("minotaur");
        }
        
        if (enemy.getName().equals("Necromancer")) {
            enemyPane.getStyleClass().add("necromancer");
        }
        
        if (enemy.getName().equals("Ogre")) {
            enemyPane.getStyleClass().add("ogre");
        }
        
        if (enemy.getName().equals("Orc")) {
            enemyPane.getStyleClass().add("orc");
        }
        
        if (enemy.getName().equals("Pixie")) {
            enemyPane.getStyleClass().add("pixie");
        }
        
        if (enemy.getName().equals("Slime")) {
            enemyPane.getStyleClass().add("slime");
        }
        
        if (enemy.getName().equals("Snake")) {
            enemyPane.getStyleClass().add("snake");
        }
        
        if (enemy.getName().equals("Spider")) {
            enemyPane.getStyleClass().add("spider");
        }
        
        if (enemy.getName().equals("Troll")) {
            enemyPane.getStyleClass().add("troll");
        }
        
        if (enemy.getName().equals("Unicorn")) {
            enemyPane.getStyleClass().add("unicorn");
        }
        
        if (enemy.getName().equals("Valjir")) {
            enemyPane.getStyleClass().add("valjir");
        }
        
        if (enemy.getName().equals("Vampire")) {
            enemyPane.getStyleClass().add("vampire");
        }
        
        if (enemy.getName().equals("Wizard")) {
            enemyPane.getStyleClass().add("wizard");
        }
        
        if (enemy.getName().equals("Wolf")) {
            enemyPane.getStyleClass().add("wolf");
        }
        
        if (enemy.getName().equals("Wraith")) {
            enemyPane.getStyleClass().add("wraith");
        }
        
        if (enemy.getName().equals("Wyvern")) {
            enemyPane.getStyleClass().add("wyvern");
        }
        
        if (enemy.getName().equals("Zombie")) {
            enemyPane.getStyleClass().add("zombie");
        }
    }
    
    /**
     * Sets up the enemy object.
     * @ensure The proper multipliers have been applied to the enemy.
     */
    public void parseEvent() {
        if(!location.name().equals("Tower of Halvabor")){
            hasKey = decision.hasKey();
            enemy = decision.getEnemy();

            if (enemy.getHp() / multiplier != enemy.maxHp()) {
                enemy.setDef(enemy.getDef() * multiplier);
                enemy.setStr(enemy.getStr() * multiplier);
                enemy.setHp(enemy.getHp() * multiplier);
            }

            maxHp = enemy.maxHp() * multiplier;
        }
        else{
            enemy = new Enemy(500,80,80,"Valjir");
            maxHp = 500;
            descriptionLabel.setVisible(true);
        }
    }
    
    /**
     * Calculates the percentage that an event is likely to happen.  Returns true
     * if the event will happen or false if it does not happen.
     * @param chance The likelihood percentage.
     * @return True if random number is less than the specified percentage, false
     * if the random number is larger.
     * @ensure A boolean value is returned.  
     */
    public boolean chance(double chance) {

        //calculate chance to befriend
        Random random = new Random();
        double r = random.nextDouble();
        boolean success = r < chance / 100;

        return success;
    }
}
