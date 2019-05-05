package Events;

import Game.Combat;
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
    private Scanner console = new Scanner(System.in);
    private Enemy enemy = new Enemy(10,1,1,"Unicorn");
    private boolean deadFlag = false;
    private boolean friendFlag = false;
    private boolean hasKey = false;
    private boolean hasCombat = true;
    
    public Unicorn() {
    }

    @Override
    public String name() {
        return name;
    }
    
    @Override
    public void hasKey(boolean hasKey){
        this.hasKey = hasKey;
    }
    
    @Override
    public boolean hasKey() {
        return hasKey;
    } 
    
    @Override
    public boolean hasCombat(){
        return hasCombat;
    }
    
    @Override
    public Enemy getEnemy(){
        return enemy;
    }
}
