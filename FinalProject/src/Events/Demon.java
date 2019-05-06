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
public class Demon implements EventInterface{
    
    private final String name = "Investigate the smoking pit";
    private Enemy enemy = new Enemy(40,2,3,"Demon");
    private boolean hasKey = false;

    public Demon() {
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
