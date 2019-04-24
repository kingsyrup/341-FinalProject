package Locations;

import static Game.GameBoard.*;
import Game.Menu;
import Interfaces.*;
import java.util.*;
/**
 *
 * @author xg6856vd
 */
public class Town implements LocationInterface {
    
    private ArrayList<EventInterface> events = new ArrayList();
    private Menu eventMenu = new Menu();

    public Town() {
    }

    public Town(ArrayList<EventInterface> events) {
        this.events = events;
    }
    
    @Override
    public String name() {
        return "Ghenki City";
    }

    @Override
    public String description() {
        return "You reach the gates of a bustling city.  Where will you go?";
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
            eventMenu.addItem("Pray in the chapel");
            eventMenu.addItem("Spend the night in the inn");
            eventMenu.addItem("Relax by the fountain in the city square");
            eventMenu.addItem("Visit the library");
        }
        
        System.out.print(eventMenu.showMenu());
        userSelection = console.nextInt();
        switch(userSelection){
            //leave the city
            case 1:
                System.out.println("You depart from Ghenki City in search of "
                        + "a new adventure");
                break;
            //flavor text
            case 2:
                break;
            //restore hp
            case 3:
                hero.setHp(hero.maxHp());
                break;
            //easter egg
            case 4:
                if(visitCount != 7){
                    System.out.println("You sit down on a bench next to a "
                            + "silvered-hair man.  You attempt to start a "
                            + "conversation with him, but he seems to ignore you.");
                    visitCount++;
                }
                else{
                    System.out.println("The silvered-hair man draws a breath and "
                            + "says, \"You seem to have trouble leaving this place"
                            + ".  Perhaps this will help.\"");
                    System.out.println("You receive a strange-looking sword.");
                    ArrayList<ItemInterface> imbaSword = items.tier(100);
                    hero.addToInventory(imbaSword.get(0));
                    visitCount++;
                }
                break;
            //save?
            case 5:
                //save and prompt to exit or keep playing
                break;
            default:
                break;
        }
    }
    
    @Override
    public ArrayList<EventInterface> getEvents(){
        return events;
    }
}
