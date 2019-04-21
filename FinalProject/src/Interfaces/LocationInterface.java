package Interfaces;

import java.util.ArrayList;

/**
 *
 * @author xg6856vd
 */
public interface LocationInterface {
    
    public String name();
    public String description();
    public EventInterface addEvent();
    public ArrayList<EventInterface> getEvents();
}
