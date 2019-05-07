package Locations;

import Interfaces.*;
import java.util.*;
/**
 *
 * @author xg6856vd
 */
public class Mountains implements LocationInterface {
    
    private ArrayList<EventInterface> events = new ArrayList();
    private boolean visited = false;

    public Mountains() {
    }

    public Mountains(ArrayList<EventInterface> events) {
        this.events = events;
    }
    
    @Override
    public String name() {
        return "Dashuk Mountains";
    }
    
    @Override
    public String description() {
        return "You begin the ascent up the craggy slopes...";
    }

    @Override
    public void addEvent(EventInterface event) {
        events.add(event);
    }

    @Override
    public ArrayList<EventInterface> getEvents(){
        return events;
    }
    
    @Override
    public void removeEvent(EventInterface event){
        this.events.remove(event);
    }
}
