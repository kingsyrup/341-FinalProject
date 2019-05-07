package Game;
import Interfaces.*;
import Items.*;
import NPCs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The GameBoard class allows global access to pertinent game data.
 * @author Ajay Basnyat, Erik Bjorngaard
 */
public class GameBoard {

    /**
     * The player's character.
     */
    public static Hero hero = new Hero();
    
    /**
     * Multiplier used to scale game difficulty based on how many keys have been found.
     */
    public static int multiplier;

    /**
     * An array list that contains all the items that can be dropped in the game.
     */
    public static ItemList items = new ItemList();
    
    /**
     * An array list that contains all the events that a location may have.
     */
    public static ArrayList<EventInterface> events = new ArrayList();

    /**
     * An array list of all the locations to which the player can travel.
     */
    public static List<LocationInterface> locations = new ArrayList();

    /**
     * Visit count for hidden Easter egg.
     */
    public static int visitCount = 0;
}
