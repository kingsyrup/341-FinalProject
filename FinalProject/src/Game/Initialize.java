package Game;

import Events.*;
import static Game.GameBoard.*;
import Interfaces.*;
import Locations.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author xg6856vd
 */
public final class Initialize {

    public static void init() {
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
        events.add(new Dragon());
        events.add(new Goblin());
        events.add(new Harpy());
        events.add(new Kobold());
        events.add(new Ogre());
        events.add(new Slime());
        events.add(new Troll());
        events.add(new Unicorn());
        events.add(new Vampire());
        events.add(new Wraith());
        events.add(new Wyvern());
        events.add(new Zombie());
    }
    
    public ArrayList<EventInterface> getEvents(){
        return events;
    }
    
    public static void addLocations(){
        locations.add(new StartingArea());
        locations.add(new StartingArea1());
        locations.add(new StartingArea11());
        /*locations.add(new StartingArea_1());
        locations.add(new StartingArea_2());
        locations.add(new StartingArea_3());
        locations.add(new StartingArea_4());*/
    }
    
    public ArrayList<LocationInterface> getLocations(){
        return locations;
    }
    
}
