/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        for(int i = 0; i < locations.size(); i ++){
            for(int j = 0; j < 3; j ++){
                Random rng = new Random();
                int index = (rng.nextInt(events.size()));
                locations.get(i).addEvent(events.get(index));
                events.remove(index);
            }
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
    }
    
    public ArrayList<LocationInterface> getLocations(){
        return locations;
    }
    
}
