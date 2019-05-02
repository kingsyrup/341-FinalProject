package Locations;

import static Game.GameBoard.*;
import Helpers.Menu;
import Interfaces.*;
import java.util.*;

/**
 *
 * @author xg6856vd
 */
public class Town implements LocationInterface {

    private ArrayList<EventInterface> events = new ArrayList();
    private Menu eventMenu = new Menu();
    private String name = "Ghenki City";
    private String description = "You reach the gates of a bustling city.  Where will you go?";
    private boolean visited = false;

    public Town() {
    }

    public Town(ArrayList<EventInterface> events) {
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
            eventMenu.addItem("Pray in the chapel");
            eventMenu.addItem("Spend the night in the inn");
            eventMenu.addItem("Relax by the fountain in the city square");
        }

        do {
            System.out.print(eventMenu.showMenu());
            userSelection = console.nextInt();
            switch (userSelection) {
                //leave the city
                case 1:
                    System.out.println("You depart from Ghenki City in search of "
                            + "a new adventure");
                    break;
                //chapel visit
                case 2:
                    if (hero.getHp() < hero.maxHp() + 50) {
                        System.out.println("You pray in the chapel.");
                        System.out.println("You feel a renewed sense of purpose, "
                                + "your health has been temporarily increased!\n");
                        hero.setHp(hero.getHp() + 50);
                    } else {
                        System.out.println("You pray in the chapel.\n");
                    }
                    break;
                //restore hp
                case 3:
                    if (hero.getHp() < hero.maxHp()) {
                        System.out.print("You feel well rested.  Your health has been"
                                + " restored.\n");
                        hero.setHp(hero.maxHp());
                    } else {
                        System.out.print("You feel well rested./n");
                    }
                    break;
                //easter egg
                case 4:
                    if (visitCount != 7) {
                        System.out.println("You sit down on a bench next to a "
                                + "silvered-hair man.  You attempt to start a "
                                + "conversation with him, but he seems to ignore you.\n");
                        visitCount++;
                    } else {
                        System.out.println("The silvered-hair man draws a breath and "
                                + "says, \"You seem to have trouble leaving this place"
                                + ".  Perhaps this will help.\"");
                        System.out.println("You receive a strange-looking sword.\n");
                        ArrayList<ItemInterface> imbaSword = items.tier(100);
                        hero.addToInventory(imbaSword.get(0));
                        visitCount++;
                    }
                    break;
                default:
                    System.out.println(description);
                    break;
            }
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
