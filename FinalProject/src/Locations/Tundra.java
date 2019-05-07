package Locations;

import Interfaces.*;
import java.util.*;

public class Tundra implements LocationInterface {
    
    private String name = "Frostburn Tundra";
    private ArrayList<EventInterface> events = new ArrayList();

    public Tundra() {
    }

    @Override
    public String name() {
        return name;
    }
    
    @Override
    public String description() {
        return "You start to shiver as you venture on into the icy tundra...";
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
