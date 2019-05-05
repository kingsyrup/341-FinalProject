package Events;

import Game.Combat;
import Interfaces.EventInterface;
import NPCs.Enemy;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */
public class Dragon implements EventInterface {
    
    private final String name ="Dragon Encounter";
    private final String description = "You stumble upon a goblin gathering "
            + "water at a stream.";
    private Scanner console = new Scanner(System.in);
    private int baseHp = 100;
    private Enemy enemy = new Enemy(baseHp,10,10,"Dragon");
    private boolean flag = false;
    private boolean hasKey = false;
    private boolean hasCombat = true;
    
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
    public boolean hasCombat(){
        return hasCombat;
    }
    
    @Override
    public Enemy getEnemy(){
        return enemy;
    }
}
