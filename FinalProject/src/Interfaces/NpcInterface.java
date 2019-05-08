/**
 * @author Ajay Basnyat and Erik Bjorngaard
 * @version 5/7/2019
 *
 * Course: CS341 - Data Structures
 *
 * Assignment: Final Project 
 *
 * Purpose: Interface for use with NPCs 
 * 
 */

package Interfaces;

public interface NpcInterface {
    
    /**
     * Allows access to the name of a character.
     *
     * @require character exists
     * @ensure the name of the character is returned
     * @return String name - the name of the character 
     */
    public String getName();
    
    /**
     * Allows access to the str of a character.
     *
     * @require character exists
     * @ensure the str of the character is returned
     * @return int - the str of the character 
     */
    public int getStr();
    
    /**
     * Allows ability to set the str of a character.
     *
     * @require character exists
     * @ensure the str of the character is updated to the passed value
     * @param str - the new str of the character 
     */
    public void setStr(int str);
    
    /**
     * Allows access to the def of a character.
     *
     * @require character exists
     * @ensure the def of the character is returned
     * @return int - the def of the character 
     */
    public int getDef();
    
    /**
     * Allows ability to set the def of a character.
     *
     * @require character exists
     * @ensure the def of the character is updated to the passed value
     * @param def - the new def of the character 
     */
    public void setDef(int def);
    
    /**
     * Allows access to the hp of a character.
     *
     * @require character exists
     * @ensure the hp of the character is returned
     * @return int - the hp of the character 
     */
    public int getHp();
    
    /**
     * Allows ability to set the hp of a character.
     *
     * @require character exists
     * @ensure the hp of the character is updated to the passed value
     * @param hp - the new hp of the character 
     */
    public void setHp(int hp);
    
    /**
     * Allows access to the max hp of a character.
     *
     * @require character exists
     * @ensure the max hp of the character is returned
     * @return int - the maximum hp of the character 
     */
    public int maxHp();
    
    /**
     * Allows ability for character to attack another character.
     *
     * @require character exists
     * @ensure the name of the character is returned
     * @return String name - the name of the character 
     * @param defender is the NpcInterface character being attacked
     */
    public int attack(NpcInterface defender);
    
    /**
     * Allows access to the name of a character.
     *
     * @param damage The amount of damage to be dealt.
     * @require character exists
     * @ensure the name of the character is returned
     */
    public void attacked(int damage);
    
    /**
     * Allows access to the name of a character.
     *
     * @require character exists
     * @ensure the name of the character is returned
     * @return String name - the name of the character 
     */
    public boolean isKilled();
    
    /**
     * Allows access to the name of a character.
     *
     * @require character exists
     * @ensure the name of the character is returned
     * @return String name - the name of the character 
     */
    public int diceRoll();
}
