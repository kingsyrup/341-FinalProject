package Events;

import Interfaces.EventInterface;
import NPCs.Enemy;

/**
 *
 * @author xg6856vd
 */

public class Goblin implements EventInterface {

    private final String name = "Follow the trail of blood";
    private Enemy enemy = new Enemy(20, 1, 3, "Goblin");
    private boolean hasKey = false;

    public Goblin() {
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
    public boolean hasKey() {
        return hasKey;
    } 
    
    @Override
    public Enemy getEnemy(){
        return enemy;
    }
}
