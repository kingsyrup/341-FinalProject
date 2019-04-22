package Game;

import java.util.*;

/**
 * Creates a menu from a list of items.
 * @author Ajay Basnyat, Erik Bjorngaard
 */
public class Menu {
    
    /**
     * Creates an Item.
     */
    public static class Item {
        private String name;

        /**
         * An item to be listed in the menu.
         * @param name The name of the item.
         */
        public Item (String name) {
            this.name = name;
        }
        
        /**
         * A getter that returns the item's name.
         * @return The name of the item.
         * @ensure The name of the item is returned.
         */
        public String getName () {
            return name;
        }
    }
    
    private ArrayList<Item> items = new ArrayList<>();
    
    /**
     * The amount of items an individual frame of the menu can hold.
     */
    public static final int FRAME_SIZE = 12;
    
    private int currentFrame;
    
    /**
     * Creates a menu with initial item(s).
     * @param startingItems The initial item(s) to be listed in the menu.
     * @ensure A menu is created from the items provided.
     */
    public Menu (String... startingItems) {
        for (String str : startingItems) {
            items.add(new Item(str));
        }
        currentFrame = 0;
    }
    
    /**
     * Adds an item to the menu.
     * @param item The item to be added to the menu.
     * @ensure The item is added to the menu.
     */
    public void addItem(String item) {
        items.add(new Item(item));
    }
    
    /**
     * Shows the first frame of the menu.
     * @return The first menu frame.
     * @ensure The first menu frame is returned.
     */
    public String showMenu() {
        return showMenu(0);
    }
    
    /**
     * A recursive process that builds a menu with a set amount of frames
     * @param frame The amount of frames the menu has.
     * @return All menu frames in a formatted fashion.
     * @ensure The formatted menu in its entirety is returned.
     */
    public String showMenu(int frame) {
        StringBuilder output = new StringBuilder();
        int startIndex = frame*FRAME_SIZE;
        for (int i = 0; i < items.size(); i++) {
            if (i >= startIndex && i < startIndex + FRAME_SIZE) {
                output.append(
                        (i+1) + ") " + items.get(i).getName() + "\n");
            }
        }
        return output.toString();
    }
    
}
