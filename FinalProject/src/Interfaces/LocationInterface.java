package Interfaces;

import java.util.ArrayList;

/**
 *
 * @author xg6856vd
 */

//             EACH LOCATION GETS A KEY - PLACE KEY IN AN EVENT

public interface LocationInterface {
    
    public String name();
    public String description();
    public void addEvent(EventInterface event);
    public void listEvents();
    public ArrayList<EventInterface> getEvents();
}
