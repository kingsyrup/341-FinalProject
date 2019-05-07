package Locations;

import Interfaces.*;
import java.util.*;

public class Marsh implements LocationInterface {
    
    private String name = "Brackmire Marsh";
    private ArrayList<EventInterface> events = new ArrayList();

    public Marsh() {
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
