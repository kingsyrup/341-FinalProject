package Locations;

import Interfaces.*;
import java.util.*;

/**
 *
 * @author xg6856vd
 */
public class Desert implements LocationInterface {

    private ArrayList<EventInterface> events = new ArrayList();
    private String name = "Kulpaki Desert";
    private String description = "The white sands seem to go on forever.";
    private boolean visited = false;

    public Desert() {
    }

    public Desert(ArrayList<EventInterface> events) {
        this.events = events;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void addEvent(EventInterface event) {
        events.add(event);
    }

    @Override
    public ArrayList<EventInterface> getEvents() {
        return events;
    }
    
    @Override
    public void removeEvent(EventInterface event){
        this.events.remove(event);
    }
}
