package Events;

import Interfaces.EventInterface;
import NPCs.Enemy;

/**
 *
 * @author xg6856vd
 */
public class Cyclops implements EventInterface {

    private final String name = "Search the nearby cave";
    private Enemy enemy = new Enemy(45, 1, 4, "Cyclops");
    private boolean hasKey = false;

    public Cyclops() {
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void hasKey(boolean hasKey) {
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
