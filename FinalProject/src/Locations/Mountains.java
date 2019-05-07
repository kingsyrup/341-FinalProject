package Locations;

import Interfaces.*;
import java.util.*;

public class Mountains implements LocationInterface {
    
    private String name = "Dashuk Mountains";
    private ArrayList<EventInterface> events = new ArrayList();

    public Mountains() {
    }

    @Override
    public String name() {
        return name;
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
