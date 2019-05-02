package Interfaces;

import java.util.ArrayList;

/**
 *
 * @author xg6856vd
 */

public interface LocationInterface {
    
    public String name();
    public String description();
    public void addEvent(EventInterface event);
    public void listEvents();
    public ArrayList<EventInterface> getEvents();
    public void removeEvent(EventInterface event);
    public void visit();
    public boolean visited();
}
