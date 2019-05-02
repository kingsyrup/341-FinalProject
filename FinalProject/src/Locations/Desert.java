package Locations;

import Helpers.Menu;
import Helpers.Switcher;
import Interfaces.*;
import java.util.*;

/**
 *
 * @author xg6856vd
 */
public class Desert implements LocationInterface {

    private ArrayList<EventInterface> events = new ArrayList();
    private Menu eventMenu = new Menu();
    private String name = "Kulpaki Desert";
    private String description = "The white sands seem to go on forever.";
    private boolean visited = false;

    public Desert() {
    }

    public Desert(ArrayList<EventInterface> events) {
        this.events = events;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void addEvent(EventInterface event) {
        events.add(event);
    }

    @Override
    public void listEvents() {

        //scanner object for inventory selection
        Scanner console = new Scanner(System.in);
        int userSelection = -1;
        if (eventMenu.size() == 0) {
            eventMenu.addItem("Travel to another location");
            for (int i = 0; i < events.size(); i++) {
                eventMenu.addItem(events.get(i).name());
            }
        }

        do {
            Switcher switcher = new Switcher();
            System.out.print(eventMenu.showMenu());

            switcher.addCaseCommand(1, new CommandInterface() {
                @Override
                public void execute(int i) {
                    System.out.println("You traveled to another location");
                }
            });
            
            if(eventMenu.size() > 1){
                for (int i = 2; i < eventMenu.size() + 1; i++) {
                    switcher.addCaseCommand(i, new CommandInterface() {
                        @Override
                        public void execute(int i) {
                            System.out.println("\n" + events.get(i - 2).description());
                            events.get(i - 2).choices();
                            eventMenu.removeItem(i-1);
                        }
                    });
                }
            }

            userSelection = console.nextInt();
            switcher.on(userSelection);
        } while (userSelection != 1);

    }

    @Override
    public ArrayList<EventInterface> getEvents() {
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
