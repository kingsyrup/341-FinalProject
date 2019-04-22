package Locations;

import Game.Menu;
import Game.Switcher;
import Interfaces.*;
import java.util.*;
/**
 *
 * @author xg6856vd
 */
public class StartingArea_1 implements LocationInterface {
    
    private ArrayList<EventInterface> events = new ArrayList();
    private Menu eventMenu = new Menu();

    public StartingArea_1() {
    }

    public StartingArea_1(ArrayList<EventInterface> events) {
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
    public void getEvents() {
        
        Switcher switcher = new Switcher();
        
        //scanner object for inventory selection
        Scanner console = new Scanner(System.in);
        int userSelection = -1;
    
        eventMenu.addItem("Travel to another location");
        for(int i = 0; i < events.size(); i++){
            eventMenu.addItem(events.get(i).name());
        }
        
        System.out.print(eventMenu.showMenu());
        
        for(int i = 2; i < 3; i++){
            switcher.addCaseCommand(i, new Command() {
                @Override
                public void execute(int i) {
                    System.out.println("\n" + events.get(i-2).description());
                    events.get(i-2).choices();

                }
            });
        }
       
        userSelection = console.nextInt();
        switcher.on(userSelection);

    }
    
}
