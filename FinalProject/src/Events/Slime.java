/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import Game.Combat;
import Interfaces.EventInterface;
import NPCs.Enemy;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */
public class Slime implements EventInterface {
    
    private final String name ="Slime Encounter";
    private final String description = "You stumble upon a goblin gathering "
            + "water at a stream.";
    private Scanner console = new Scanner(System.in);
    private Enemy enemy = new Enemy(10,1,1,"Slime");
    private boolean deadFlag = false;
    private boolean friendFlag = false;
    private boolean hasKey = false;
    
    public Slime() {
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
