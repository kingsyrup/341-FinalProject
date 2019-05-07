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
