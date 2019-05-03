package Game;
import Interfaces.*;
import Items.*;
import NPCs.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xg6856vd
 */

public class GameBoard {

    //player's character
    public static Hero hero = new Hero();
    
    //multipler used to scale difficulty based on how many keys have been found
    public static int multiplier;
    
    //instantiate items
    public static ItemList items = new ItemList();
    
    //instantiate locations and events
    public static ArrayList<EventInterface> events = new ArrayList();
    public static List<LocationInterface> locations = new ArrayList();
    
    public static int visitCount = 0;
    
    //public static int userSelection = -1;
    
    
    public static void main(String[] arg){

        //present main menu
        MainMenu.show();        
    }
}
