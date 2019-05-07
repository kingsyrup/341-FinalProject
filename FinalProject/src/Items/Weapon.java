/**
 * @author Ajay Basnyat and Erik Bjorngaard
 * @version 5/7/2019
 *
 * Course: CS341 - Data Structures
 *
 * Assignment: Final Project 
 *
 * Purpose: For creating Weapon objects
 * 
 * Implements ItemInterface
 * 
 */

package Items;

import Interfaces.ItemInterface;

/**
 * A weapon object that the player can equip to enhance their stats.
 * @author xAjay Basnyat, Erik Bjorngaard
 */
public class Weapon implements ItemInterface {
    
    private final int strModifier;
    private final int defModifier;
    private final int hpModifier;
    private final String name;
    private final int tier;
    private final String type = "Weapon";

    /**
     * Creates a weapon object with a set strength, defense, and hp modifiers, as well
     * as name and item tier.
     * @param strModifier The amount of strength the weapon provides to the player when equipped.
     * @param defModifier The amount of defense the weapon provides to the player when equipped.
     * @param hpModifier The amount of hp the weapon provides to the player when equipped.
     * @param name The weapon's name.
     * @param tier The weapon's tier.  Lower tier items are typically of lower quality.
     */
    public Weapon(int strModifier, int defModifier, int hpModifier, String name, int tier) {
        this.strModifier = strModifier;
        this.defModifier = defModifier;
        this.hpModifier = hpModifier;
        this.name = name;
        this.tier = tier;
    }

    @Override
    public String getName(){
        return name;
    }
    
    @Override
    public int getStrModifier() {
        return strModifier;
    }

    @Override
    public int getHpModifier() {
        return hpModifier;
    }

    @Override
    public int getDefModifier() {
        return defModifier;
    }
    
    @Override
    public String getType(){
        return type;
    }
    
    @Override
    public int getTier(){
        return tier;
    }
    
}