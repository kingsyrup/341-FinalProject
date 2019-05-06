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
public class Kobold implements EventInterface {
    
    private final String name = "Investigate the howling";
    private Enemy enemy = new Enemy(20,2,3,"Kobold");
    private boolean hasKey = false;
    
    public Kobold() {
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
