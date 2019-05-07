/**
 * @author Ajay Basnyat and Erik Bjorngaard
 * @version 5/7/2019
 *
 * Course: CS341 - Data Structures
 *
 * Assignment: Final Project 
 *
 * Purpose: Unique Location with name, description, events
 * 
 * Implements LocationInterface
 * 
 */

package Locations;

import Interfaces.*;
import java.util.*;

public class Marsh implements LocationInterface {
    
    private String name = "Brackmire Marsh";
    private ArrayList<EventInterface> events = new ArrayList();

    public Marsh() {
    }

    @Override
    public String name() {
        return name;
    }
    
    @Override
    public String description() {
        return "You trudge your way through the murky waters...";
    }

    @Override
    public void addEvent(EventInterface event) {
        events.add(event);
    }

    @Override
    public ArrayList<EventInterface> getEvents(){
        return events;
    }
    
    @Override
    public void removeEvent(EventInterface event){
        this.events.remove(event);
    }
}
