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
 *
 * @author xg6856vd
 */
public final class Initialize {

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
    }
    
    public static void addEvents(){
        events.add(new Bandits());
        events.add(new Beggar());
        events.add(new Child());
        events.add(new Corpse());
        events.add(new Cyclops());
        events.add(new Dragon());
        events.add(new FlowerField());
        events.add(new Goblin());
        events.add(new Gryffin());
        events.add(new Harpy());
        events.add(new Kobold());
        events.add(new Lake());
        events.add(new LavaPool());
        events.add(new Magician());
        events.add(new Merchant());
        events.add(new Minotaur());
        events.add(new Ogre());
        events.add(new OldMan());
        events.add(new Slime());
        events.add(new Stream());
        events.add(new Swamp());
        events.add(new Troll());
        events.add(new Unicorn());
        events.add(new Vampire());
        events.add(new Volcano());
        events.add(new Wagon());
        events.add(new Widow());
        events.add(new Wraith());
        events.add(new Wyvern());
        events.add(new Zombie());
    }
    
    public ArrayList<EventInterface> getEvents(){
        return events;
    }
    
    public static void addLocations(){
        locations.add(new Desert());
        locations.add(new Mines());
        locations.add(new Mountains());
        locations.add(new Plains());
        locations.add(new Marsh());
        locations.add(new Tundra());
        locations.add(new Forest());
        locations.add(new Town());
    }
    
    public List<LocationInterface> getLocations(){
        return locations;
    }
    
}
