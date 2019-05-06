/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import Interfaces.EventInterface;
import NPCs.Enemy;

public class Wraith implements EventInterface {
    
    private final String name ="Go into the crypt";
    private Enemy enemy = new Enemy(30,5,2,"Wraith");
    private boolean hasKey = false;
    
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
    public Enemy getEnemy(){
        return enemy;
    }
}
