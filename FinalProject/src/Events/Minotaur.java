package Events;

import Game.*;
import Interfaces.EventInterface;
import NPCs.Enemy;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */

public class Minotaur implements EventInterface {

    private final String name = "Minotaur Encounter";
    private final String description = "You stumble upon a goblin gathering "
            + "water at a stream.";
    private Scanner console = new Scanner(System.in);
    private Enemy enemy = new Enemy(10, 1, 1, "Minotaur");
    private boolean deadFlag = false;
    private boolean friendFlag = false;
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
    public boolean hasCombat(){
        return true;
    }
    
    @Override
    public Enemy getEnemy(){
        return enemy;
    }
}
