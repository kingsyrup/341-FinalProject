package Events;

import Game.*;
import Interfaces.EventInterface;
import NPCs.Enemy;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */

public class Goblin implements EventInterface {

    private final String name = "Goblin Encounter";
    private final String description = "You stumble upon a goblin gathering "
            + "water at a stream.";
    private Scanner console = new Scanner(System.in);
    private int baseHp;
    private Enemy enemy = new Enemy(baseHp, 1, 1, "Goblin");
    private boolean flag = false;
    private boolean hasKey = false;
    private boolean hasCombat = true;

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
    public boolean hasCombat(){
        return hasCombat;
    }
    
    @Override
    public Enemy getEnemy(){
        return enemy;
    }
}
