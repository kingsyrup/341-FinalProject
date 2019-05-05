package Locations;

import static Game.GameBoard.*;
import Interfaces.*;
import java.util.*;

/**
 *
 * @author xg6856vd
 */
public class Town implements LocationInterface {

    private ArrayList<EventInterface> events = new ArrayList();
    private String name = "Ghenki City";
    private String description = "You reach the gates of a bustling city.  Where will you go?";
    private boolean visited = false;

    public Town() {
    }

    public Town(ArrayList<EventInterface> events) {
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
    
    @Override
    public void visit() {
        visited = true;
    }
    
    @Override
    public boolean visited() {
        return visited;
    }
}
