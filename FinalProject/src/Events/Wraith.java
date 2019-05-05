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

public class Wraith implements EventInterface {
    
    private final String name ="Wraith Encounter";
    private final String description = "You stumble upon a goblin gathering "
            + "water at a stream.";
    private Scanner console = new Scanner(System.in);
    private Enemy enemy = new Enemy(10,1,1,"Wraith");
    private boolean deadFlag = false;
    private boolean friendFlag = false;
    private boolean hasKey = false;
    private boolean hasCombat = true;
    
    public Wraith() {
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
