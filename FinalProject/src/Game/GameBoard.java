package Game;
import Interfaces.*;
import Items.*;
import NPCs.*;
import Events.*;
import Locations.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */

//                     WOULD LIKE TO SCALE EVENTS/ENEMIES BASED ON
//                     HOW MANY KEYS HAVE BEEN FOUND


public class GameBoard {
    
    //player's character
    public static Hero hero = new Hero();
    
    //multipler used to scale difficulty based on how many keys have been found
    public static int multiplier = 1;
    
    //instantiate items
    public static ItemList items = new ItemList();
    
    //instantiate locations and events
    public static ArrayList<EventInterface> events = new ArrayList();
    public static ArrayList<LocationInterface> locations = new ArrayList();
    
    public static int userSelection = -1;
    
    
    public static void main(String[] arg){
        
        //add way to enter player name
        //hero.setName("name");
        
        //initialize locations and events
        Initialize.init();
        
        hero.getInventory();
        do{
        locations.get(0).listEvents();
        }
        while(userSelection != 5);
        locations.get(1).listEvents();
        locations.get(2).listEvents();
        
        
        
        Scanner console = new Scanner(System.in);
 
        hero.getInventory();

        
    }
}
