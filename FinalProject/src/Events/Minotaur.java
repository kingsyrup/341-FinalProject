package Events;

import Helpers.Menu;
import Game.*;
import Interfaces.EventInterface;
import NPCs.Enemy;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */

//             ADD FLAG TO ALTER EVENTS AFTER FIRST VISIT (if something happens)
public class Minotaur implements EventInterface {

    private final String name = "Goblin Encounter";
    private final String description = "You stumble upon a goblin gathering "
            + "water at a stream.";
    private final Menu choices = new Menu();
    private Scanner console = new Scanner(System.in);
    private Enemy goblin = new Enemy(10, 1, 1, "Goblin");
    private boolean deadFlag = false;
    private boolean friendFlag = false;
    private boolean hasKey = false;

    public Minotaur() {
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    //need a different return type
    @Override
    public void choices() {
        int userSelection = -1;

        //Goblin is alive
        if (!deadFlag) {
            choices.addItem("Attack the goblin"); //beginCombat
            choices.addItem("Attempt to befriend the goblin");  //charisma stat?
            choices.addItem("Sneak past the goblin"); //dexterity stat?
            choices.addItem("Flee"); //spd stat?
            System.out.print(choices.showMenu());

            userSelection = console.nextInt();
            //switch for choice cases
            switch (userSelection) {
                //attack the goblin
                case 1:
                    //multiplier (based on how many keys have been found)
                    int multiplier = Game.GameBoard.multiplier;

                    //if multiplier has not been applied, apply it
                    if (goblin.getHp() / multiplier != 10) {
                        goblin.setDef(goblin.getDef() * multiplier);
                        goblin.setStr(goblin.getStr() * multiplier);
                        goblin.setHp(goblin.getHp() * multiplier);
                    }
                    Combat.beginCombat(goblin, 10);
                    goblin = null;
                    deadFlag = true;
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
            if (hasKey) {
                System.out.println("You found a key.");
                hasKey = false;
                Game.GameBoard.multiplier++;
            }
        }
    }

    @Override
    public void hasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }
    
    @Override
    public boolean hasKey() {
        return hasKey;
    } 
    
    @Override
    public boolean hasCombat(){
        return true;
    }
    
    @Override
    public Enemy getEnemy(){
        return null;
    }
}
