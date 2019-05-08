/**
 * @author Ajay Basnyat and Erik Bjorngaard
 * @version 5/7/2019
 *
 * Course: CS341 - Data Structures
 *
 * Assignment: Final Project 
 *
 * Purpose: Unique Event class to be used with event selection. 
 * 
 * Implements EventInterface
 */
package Events;

import Interfaces.EventInterface;
import NPCs.Enemy;


public class Pixie implements EventInterface{
        
    private final String name ="Search the hollow stump";
    private Enemy enemy = new Enemy(10,1,1,"Pixie");
    private boolean hasKey = false;

    public Pixie() {
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
    public Enemy getEnemy(){
        return enemy;
    }
}
