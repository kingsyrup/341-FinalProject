package Events;

import Interfaces.EventInterface;
import NPCs.Enemy;

/**
 *
 * @author xg6856vd
 */
public class Lake implements EventInterface{

    private String name = "";
    private String description = "";
    private boolean hasKey = false;
    private boolean hasCombat = false;
    
    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void choices() {
        if (hasKey) {
                System.out.println("You found a key.");
                hasKey = false;
                Game.GameBoard.multiplier++;
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
        return hasCombat;
    }
    
    @Override
    public Enemy getEnemy(){
        return null;
    }
}
