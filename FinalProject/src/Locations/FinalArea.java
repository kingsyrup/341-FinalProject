package Locations;

import Game.Combat;
import Game.Menu;
import Game.Switcher;
import Interfaces.*;
import NPCs.Enemy;
import java.util.*;
/**
 *
 * @author xg6856vd
 */
public class FinalArea implements LocationInterface {
    
    private ArrayList<EventInterface> events = new ArrayList();
    private Menu eventMenu = new Menu();

    public FinalArea() {
    }

    public FinalArea(ArrayList<EventInterface> events) {
        this.events = events;
    }
    
    @Override
    public String name() {
        return "Tower of Halvabor";
    }

    @Override
    public String description() {
        return "You use the 7 keys to unlock the door leading to the Tower of "
                + "Halvabor.  The door swings open revealing a giant monster "
                + "sleeping on endless riches.";
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
    
        if(eventMenu.size() == 0){
            eventMenu.addItem("Travel to another location");
            eventMenu.addItem("Attack the monster");
        }
        
        System.out.print(eventMenu.showMenu());
        
        userSelection = console.nextInt();
        switch(userSelection){
            case 1:
                break;
            case 2:
                Enemy boss = new Enemy(500,15,15,"Valjir");
                Combat.beginCombat(boss);
                System.out.println("\nYou beat the game.");
                Game.Overworld.userSelection = 11;
                break;
        }
    }
    
    @Override
    public ArrayList<EventInterface> getEvents(){
        return events;
    }
}
