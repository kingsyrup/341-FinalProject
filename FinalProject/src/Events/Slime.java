/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import Interfaces.EventInterface;
import NPCs.Enemy;

/**
 *
 * @author xg6856vd
 */
public class Slime implements EventInterface {
    
    private final String name ="Follow the trail of ooze";
    private Enemy enemy = new Enemy(10,1,1,"Slime");
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
    public Enemy getEnemy(){
        return enemy;
    }
}
