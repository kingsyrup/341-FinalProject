package Locations;

import Interfaces.*;
import java.util.*;

public class Plains implements LocationInterface {
    
    private String name = "Golbrow Plains";
    private ArrayList<EventInterface> events = new ArrayList();

    public Plains() {
    }
    
    @Override
    public String name() {
        return name;
    }
    
    @Override
    public String description() {
        return "You feel a sense of unease as you traverse the wide-open plains...";
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
