package Locations;

import Interfaces.*;
import java.util.*;
/**
 *
 * @author xg6856vd
 */
public class Marsh implements LocationInterface {
    
    private ArrayList<EventInterface> events = new ArrayList();
    private boolean visited = false;

    public Marsh() {
    }

    public Marsh(ArrayList<EventInterface> events) {
        this.events = events;
    }
    
    @Override
    public String name() {
        return "Brackmire Marsh";
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
    
    @Override
    public void visit() {
        visited = true;
    }
    
    @Override
    public boolean visited() {
        return visited;
    }
}
