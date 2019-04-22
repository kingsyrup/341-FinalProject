package Events;

import Game.Menu;
import Interfaces.EventInterface;
/**
 *
 * @author xg6856vd
 */
public class GoblinAttacks implements EventInterface {

    private final String name ="Goblin Attack";
    private final String description = "A goblin attacks the unsuspecting hero.";
    private final Menu choices = new Menu();
    
    public GoblinAttacks() {
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }
    
    @Override
    public Menu choices(){
        choices.addItem("Attack the goblin");
        choices.addItem("Attempt to befriend the goblin");
        choices.addItem("Sneak past the goblin");
        choices.addItem("Flee");
        
        return choices;
    }
    
}
