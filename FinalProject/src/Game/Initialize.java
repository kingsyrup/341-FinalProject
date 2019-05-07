package Game;

import Events.*;
import static Game.GameBoard.*;
import Interfaces.*;
import Items.ItemList;
import Locations.*;
import NPCs.Hero;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class initializes game data when a new game is started.
 * @author Ajay Basnyat, Erik Bjorngaard
 */
public final class Initialize {

    /**
     * Initialize game data.
     * @ensure The game data is initialized.
     */
    public static void init() {

        //player's character
        hero = new Hero();

        //multipler used to scale difficulty based on how many keys have been found
        multiplier = 1;

        //instantiate items
        items = new ItemList();

        //instantiate locations and events
        events = new ArrayList();
        locations = new ArrayList();
  
        //used for tracking easter egg
        visitCount = 0;
        
        //add locations and events to game
        addLocations();
        addEvents();
        
        //add random events to locations
        for(int i = 0; i < locations.size(); i ++){
        
            for(int j = 0; j < 3; j ++){
                Random rng = new Random();
                int index = (rng.nextInt(events.size()));
                locations.get(i).addEvent(events.get(index));
                events.remove(index);
            }
            
            //generate key, place in random event
            Random random = new Random();
            double r = random.nextDouble();
            int keyIndex;
            if      (r < 1.0/3.0) keyIndex = 0;
            else if (r < 2.0/3.0) keyIndex = 1;
            else                  keyIndex = 2;
            
            locations.get(i).getEvents().get(keyIndex).hasKey(true);
        }
        
        //finally, add town location
        locations.add(new Town());
    }
    
     /**
     * Add events to the event array list.
     * @ensure The events are added to the event array list.
     */
    public static void addEvents(){
        events.add(new Bandit());
        events.add(new Cyclops());
        events.add(new Demon());
        events.add(new Dragon());
        events.add(new Dwarf());
        events.add(new Elf());
        events.add(new Giant());
        events.add(new Goblin());
        events.add(new Gryffin());
        events.add(new Harpy());
        events.add(new Hydra());
        events.add(new Kobold());
        events.add(new Lich());
        events.add(new Medusa());
        events.add(new Minotaur());
        events.add(new Necromancer());
        events.add(new Ogre());
        events.add(new Orc());
        events.add(new Pixie());
        events.add(new Slime());
        events.add(new Snake());
        events.add(new Spider());
        events.add(new Troll());
        events.add(new Unicorn());
        events.add(new Vampire());
        events.add(new Wizard());
        events.add(new Wolf());
        events.add(new Wraith());
        events.add(new Wyvern());
        events.add(new Zombie());
    }
    
    /**
     * Retrieve the events from event array list.
     * @return all event in the event array list.
     * @ensure all event in the event array list are returned.
     */
    public ArrayList<EventInterface> getEvents(){
        return events;
    }
    
    /**
     * Add locations to the location array list.
     * @ensure The locations are added to the location array list.
     */
    public static void addLocations(){
        locations.add(new Desert());
        locations.add(new Mines());
        locations.add(new Mountains());
        locations.add(new Plains());
        locations.add(new Marsh());
        locations.add(new Tundra());
        locations.add(new Forest());
    }
    
    /**
     * Retrieve the locations from location array list.
     * @return all locations in the location array list.
     * @ensure all locations in the location array list are returned.
     */
    public List<LocationInterface> getLocations(){
        return locations;
    }
    
}
