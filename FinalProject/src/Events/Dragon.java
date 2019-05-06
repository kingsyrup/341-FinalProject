package Events;

import Interfaces.EventInterface;
import NPCs.Enemy;

/**
 *
 * @author xg6856vd
 */
public class Dragon implements EventInterface {
    
    private final String name = "Search the hidden cavern";
    private Enemy enemy = new Enemy(100,10,10,"Dragon");
    private boolean hasKey = false;

    public Dragon() {
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
    public boolean hasKey(){
        return hasKey;
    }
    
    @Override
    public Enemy getEnemy(){
        return enemy;
    }
}
