package Interfaces;

/**
 *
 * @author xg6856vd
 */
public interface ItemInterface {
    
    /**
     * Allows access to the str modifier of an item.
     *
     * @require item exists
     * @ensure the str modifier of the item is returned
     * @return int strModifier 
     */
    public int getStrModifier();
    
    /**
     * Allows access to the hp modifier of an item.
     *
     * @require item exists
     * @ensure the hp modifier of the item is returned
     * @return int hpModifier 
     */
    public int getHpModifier();
    
    /**
     * Allows access to the def modifier of an item.
     *
     * @require item exists
     * @ensure the def modifier of the item is returned
     * @return int defModifier 
     */
    public int getDefModifier();
    
    /**
     * Allows access to the type of an item.
     *
     * @require item exists
     * @ensure the type of the item is returned
     * @return String type of the item
     */
    public String getType();
    
    /**
     * Allows access to the tier of an item.
     *
     * @require item exists
     * @ensure the tier of the item is returned
     * @return int tier 
     */
    public int getTier();
    
    /**
     * Allows access to the name of an item.
     *
     * @require item exists
     * @ensure the name of the item is returned
     * @return String name - the name of the item 
     */
    public String getName();
}
