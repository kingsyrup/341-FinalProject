package Events;

import Interfaces.EventInterface;
import NPCs.Enemy;

/**
 *
 * @author xg6856vd
 */
public class Unicorn implements EventInterface {
    
    private final String name ="Grab a drink from a nearby stream.";
    private Enemy enemy = new Enemy(70,1,4,"Unicorn");
    private boolean hasKey = false;

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
    public Enemy getEnemy(){
        return enemy;
    }
}
