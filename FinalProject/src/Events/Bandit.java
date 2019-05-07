package Events;

import Interfaces.EventInterface;
import NPCs.Enemy;

public class Bandit implements EventInterface {
    
    private final String name = "Search the wagon";
    private Enemy enemy = new Enemy(30,2,3,"Bandit");
    private boolean hasKey = false;

    public Bandit() {
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
