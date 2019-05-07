package Locations;

import Interfaces.*;
import java.util.*;

public class FinalArea implements LocationInterface {
    
    private ArrayList<EventInterface> events = new ArrayList();
    private String name = "Tower of Halvabor";
    private String description = "You use the 7 keys to unlock the door leading to the Tower of "
                + "Halvabor.  The door swings open revealing a giant monster "
                + "sleeping on endless riches.";

    public FinalArea() {
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
