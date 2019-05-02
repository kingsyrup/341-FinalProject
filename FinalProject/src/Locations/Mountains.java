package Locations;

import Helpers.Menu;
import Helpers.Switcher;
import Interfaces.*;
import java.util.*;
/**
 *
 * @author xg6856vd
 */
public class Mountains implements LocationInterface {
    
    private ArrayList<EventInterface> events = new ArrayList();
    private Menu eventMenu = new Menu();
    private boolean visited = false;

    public Mountains() {
    }

    public Mountains(ArrayList<EventInterface> events) {
        this.events = events;
    }
    
    @Override
    public String name() {
        return "Dashuk Mountains";
    }

    @Override
    public String description() {
        return "You begin the ascent up the craggy slopes.";
    }

    @Override
    public void addEvent(EventInterface event) {
        events.add(event);
    }

    @Override
    public void listEvents() {
        
        Switcher switcher = new Switcher();
        
        //scanner object for inventory selection
        Scanner console = new Scanner(System.in);
        int userSelection = -1;
    
        if(eventMenu.size() == 0){
            eventMenu.addItem("Travel to another location");
            for(int i = 0; i < events.size(); i++){
                eventMenu.addItem(events.get(i).name());
            }
        }
        
        System.out.print(eventMenu.showMenu());
        
        for(int i = 2; i < 5; i++){
            switcher.addCaseCommand(i, new CommandInterface() {
                @Override
                public void execute(int i) {
                    System.out.println("\n" + events.get(i-2).description());
                    events.get(i-2).choices();
                    eventMenu.removeItem(i-1);
                }
            });
        }
       
        userSelection = console.nextInt();
        switcher.on(userSelection);

    }
    
    @Override
    public ArrayList<EventInterface> getEvents(){
        return events;
    }
    
    @Override
    public void removeEvent(EventInterface event){
        this.events.remove(event);
    }
    
    @Override
    public void visit() {
        visited = true;
    }
    
    @Override
    public boolean visited() {
        return visited;
    }
}
