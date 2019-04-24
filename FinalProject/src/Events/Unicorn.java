package Events;

import Game.Combat;
import Game.Menu;
import Interfaces.EventInterface;
import NPCs.Enemy;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */
public class Unicorn implements EventInterface {
    
    private final String name ="Grab a drink from a nearby stream.";
    private final String description = "As you approach the stream, you notice "
            + "it becoming quieter.  A sudden movement grabs your attention.  "
            + "Standing near the stream is a majestic creature.";
    private final Menu choices = new Menu();
    private Scanner console = new Scanner(System.in);
    private Enemy goblin = new Enemy(10,1,1,"Unicorn");
    private boolean deadFlag = false;
    private boolean friendFlag = false;
    private boolean hasKey = false;
    
    public Unicorn() {
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
    public void choices(){
        int userSelection = -1;
        
        //Goblin is alive
        if(!deadFlag){
            choices.addItem("Attack the unicorn"); //beginCombat
            choices.addItem("Attempt to befriend the unicorn");  //charisma stat?
            choices.addItem("Leave the unicorn alone"); //dexterity stat?
            choices.addItem("Run away from the unicorn"); //spd stat?
            System.out.print(choices.showMenu());

            userSelection = console.nextInt();
            //switch for choice cases
            switch(userSelection){
                //attack the goblin
                case 1:
                    //multiplier (based on how many keys have been found)
                    int multiplier = Game.GameBoard.multiplier;
                    
                    //if multiplier has not been applied, apply it
                    if(goblin.getHp() / multiplier != 10){
                        goblin.setDef(goblin.getDef() * multiplier);
                        goblin.setStr(goblin.getStr() * multiplier);
                        goblin.setHp(goblin.getHp() * multiplier);
                    }
                    Combat.beginCombat(goblin);
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
        }
        if(hasKey){
                    System.out.println("You found a key.");
                    hasKey = false;
                    Game.GameBoard.multiplier++;
                }
    }
    
    @Override
    public void hasKey(boolean hasKey){
        this.hasKey = hasKey;
    }
}
