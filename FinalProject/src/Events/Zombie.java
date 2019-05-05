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
public class Zombie implements EventInterface {
    
    private final String name ="Zombie Encounter";
    private final String description = "You stumble upon a goblin gathering "
            + "water at a stream.";
    private Scanner console = new Scanner(System.in);
    private Enemy enemy = new Enemy(10,1,1,"Zombie");
    private boolean deadFlag = false;
    private boolean friendFlag = false;
    private boolean hasKey = false;
    private boolean hasCombat = true;
    
    public Zombie() {
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
        return hasCombat;
    }
    
    @Override
    public Enemy getEnemy(){
        return enemy;
    }
}
