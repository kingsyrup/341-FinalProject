package Locations;

import Game.Menu;
import Interfaces.EventInterface;
import Interfaces.LocationInterface;
import java.util.ArrayList;
/**
 *
 * @author xg6856vd
 */
public class StartingArea implements LocationInterface {
    
    private ArrayList<EventInterface> events = new ArrayList();
    private Menu eventMenu = new Menu();

    public StartingArea() {
    }

    public StartingArea(ArrayList<EventInterface> events) {
        this.events = events;
    }
    
    @Override
    public String name() {
        return "Starting Area";
    }

    @Override
    public String description() {
        return "The area in which you begin the game.";
    }

    @Override
    public void addEvent(EventInterface event) {
        events.add(event);
    }

    /*@Override
    public ArrayList<EventInterface> getEvents() {
        return events;
    }*/
    
    @Override
    public Menu getEvents() {
        
        for(int i = 0; i < events.size(); i++){
            eventMenu.addItem(events.get(i).name());
        }
        
        return eventMenu;
    }
    
}
