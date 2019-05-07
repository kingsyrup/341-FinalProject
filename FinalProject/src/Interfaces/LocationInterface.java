package Interfaces;

import java.util.ArrayList;

/**
 *
 * @author xg6856vd
 */

public interface LocationInterface {
    
    /**
     * Allows access to the name of a location.
     *
     * @require location exists
     * @ensure the name of the location is returned
     * @return String name - the name of the location 
     */
    public String name();
    
    /**
     * Allows access to the description of a location.
     *
     * @require location exists
     * @ensure the description of the location is returned
     * @return String - the description of the location 
     */
    public String description();
    
    /**
     * Allows ability to add event to a location.
     *
     * @require location exists
     * @ensure the passed event is added to the location
     * @param event - is the event to be added to the location
     */
    public void addEvent(EventInterface event);
    
    /**
     * Allows access to the events of a location.
     *
     * @require location exists
     * @ensure the events of the location are returned
     * @return ArrayList<EventInterface> - all of the events in the location 
     */
    public ArrayList<EventInterface> getEvents();
    
    /**
     * Allows ability to remove an event from a location.
     *
     * @require location exists
     * @ensure the passed event is removed from the location
     * @param event - is the event to be removed from the location 
     */
    public void removeEvent(EventInterface event);
}
