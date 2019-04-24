package Locations;

import Game.Menu;
import Game.Switcher;
import Interfaces.*;
import java.util.*;
/**
 *
 * @author xg6856vd
 */
public class Forest implements LocationInterface {
    
    private ArrayList<EventInterface> events = new ArrayList();
    private Menu eventMenu = new Menu();

    public Forest() {
    }

    public Forest(ArrayList<EventInterface> events) {
        this.events = events;
    }
    
    @Override
    public String name() {
        return "Weisgrow Forest";
    }

    @Override
    public String description() {
        return "The trees of Weisgrow Forest tower before you.";
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
    
    @Override
    public ArrayList<EventInterface> getEvents(){
        return events;
    }
}
