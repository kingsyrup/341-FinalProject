package Locations;

import Interfaces.*;
import java.util.*;

public class Mines implements LocationInterface {
    
    private String name = "Deepholm Mines";
    private ArrayList<EventInterface> events = new ArrayList();

    public Mines() {
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
