package Events;

import Game.*;
import Interfaces.EventInterface;
import NPCs.Enemy;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */
public class Cyclops implements EventInterface {

    private final String name = "Search the nearby cave";
    private String description = "A massive cyclops attacks you in the dark.";
    private Scanner console = new Scanner(System.in);
    private int baseHp = 10;
    private Enemy enemy = new Enemy(baseHp, 1, 1, "Cyclops");
    private boolean flag = false;
    private boolean hasKey = false;
    private boolean hasCombat = true;

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
    public boolean hasCombat(){
        return hasCombat;
    }
    
    @Override
    public Enemy getEnemy(){
        return enemy;
    }
}
