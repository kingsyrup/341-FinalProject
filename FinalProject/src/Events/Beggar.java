package Events;

import Interfaces.EventInterface;

/**
 *
 * @author xg6856vd
 */
public class Beggar implements EventInterface {
    
    private String name = "Beggar";
    private String description = "";
    private boolean hasKey = false;
    
    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void choices() {
        if (hasKey) {
                System.out.println("You found a key.");
                hasKey = false;
                Game.GameBoard.multiplier++;
            }
    }

    @Override
    public void hasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }
    
}
