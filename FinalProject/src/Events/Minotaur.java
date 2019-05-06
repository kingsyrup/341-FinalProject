package Events;

import Interfaces.EventInterface;
import NPCs.Enemy;

/**
 *
 * @author xg6856vd
 */

public class Minotaur implements EventInterface {

    private final String name = "Enter the labyrinth";
    private Enemy enemy = new Enemy(45, 3, 3, "Minotaur");
    private boolean hasKey = false;

    public Minotaur() {
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
