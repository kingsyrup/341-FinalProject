/**
 * @author Ajay Basnyat and Erik Bjorngaard
 * @version 5/7/2019
 *
 * Course: CS341 - Data Structures
 *
 * Assignment: Final Project 
 *
 * Purpose: Interface for use with Events 
 * 
 */

package Interfaces;

import NPCs.Enemy;

/**
 *
 * @author xg6856vd
 */
public interface EventInterface {
    
    /**
     * Allows access to the name of an event.
     *
     * @require event exists
     * @ensure the name of the event is returned
     * @return String the name of the event
     */
    public String name();
    
    /**
     * Allows ability to set the key status of an event.
     *
     * @param hasKey is the new status of the key
     * @require event exists
     * @ensure the event's key status is correctly updated with the new boolean
     * value. If true, the event has a key, false if not.
     */
    public void hasKey(boolean hasKey);
    
    /**
     * Allows access to the key status of an event.
     *
     * @require event exists
     * @ensure the current status of hasKey is returned
     * @return boolean hasKey. True if the event has a key, false otherwise
     */
    public boolean hasKey();
    
    /**
     * Allows access to the enemy of an event.
     *
     * @require event exists
     * @ensure the enemy of the event is returned
     * @return Enemy - the enemy of the event. Return null if enemy does not exist
     */
    public Enemy getEnemy();
}
