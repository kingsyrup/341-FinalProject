package Interfaces;

import NPCs.Enemy;

/**
 *
 * @author xg6856vd
 */
public interface EventInterface {
    
    public String name();
    public String description();
    public void choices();
    public void hasKey(boolean hasKey);
    public boolean hasKey();
    public boolean hasCombat();
    public Enemy getEnemy();
}
