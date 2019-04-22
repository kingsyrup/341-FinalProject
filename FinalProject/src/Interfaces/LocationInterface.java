package Interfaces;

import Game.Menu;
import java.util.ArrayList;

/**
 *
 * @author xg6856vd
 */
public interface LocationInterface {
    
    public String name();
    public String description();
    public void addEvent(EventInterface event);
    public Menu getEvents();
}
