package Events;

import Interfaces.EventInterface;
import NPCs.Enemy;

/**
 *
 * @author xg6856vd
 */
public class Wagon implements EventInterface{

    private String name = "";
    private String description = "";
    private boolean hasKey = false;
    
    @Override
    public String name() {
        return name;
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
        return false;
    }
    
    @Override
    public Enemy getEnemy(){
        return null;
    }
}
