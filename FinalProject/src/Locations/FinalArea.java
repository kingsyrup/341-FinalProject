package Locations;

import Interfaces.*;
import NPCs.Enemy;
import java.util.*;
/**
 *
 * @author xg6856vd
 */
public class FinalArea implements LocationInterface {
    
    private ArrayList<EventInterface> events = new ArrayList();
    private String name = "Tower of Halvabor";
    private String description = "You use the 7 keys to unlock the door leading to the Tower of "
                + "Halvabor.  The door swings open revealing a giant monster "
                + "sleeping on endless riches.";
    private boolean visited = false;

    public FinalArea() {
    }

    public FinalArea(ArrayList<EventInterface> events) {
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
    public ArrayList<EventInterface> getEvents(){
        return events;
    }
    
    @Override
    public void removeEvent(EventInterface event){
        this.events.remove(event);
    }
}
