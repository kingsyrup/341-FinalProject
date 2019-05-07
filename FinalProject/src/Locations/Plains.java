package Locations;

import Interfaces.*;
import java.util.*;
/**
 *
 * @author xg6856vd
 */
public class Plains implements LocationInterface {
    
    private ArrayList<EventInterface> events = new ArrayList();
    private boolean visited = false;

    public Plains() {
    }

    public Plains(ArrayList<EventInterface> events) {
        this.events = events;
    }
    
    @Override
    public String name() {
        return "Golbrow Plains";
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
