/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

import Interfaces.ItemInterface;
import java.util.ArrayList;

/**
 *
 * @author xg6856vd
 */

//Items that can be found in the game, divided into tiers
public final class ItemList {
    
    private final ArrayList<ItemInterface> items = new ArrayList();
   
    public ItemList(){
        this.generateItems();
    }
    public void generateItems(){
        //Armor
        items.add(new Armor(0,1,10,"Copper Breasplate",1));
        
        //Weapon
        items.add(new Weapon(3,0,0,"Dagger",1));
        items.add(new Weapon(1000,1000,1000, "Sword of One Thousand Truths",100));
        
        //Another category for consumables?
    }
    
    public void removeItem(ItemInterface item){
        items.remove(item);
    }
    
    public ArrayList<ItemInterface> getItems(){
        return items;
    }
    
    public ArrayList<ItemInterface> tier(int tier){
        
        ArrayList<ItemInterface> t = new ArrayList();
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getTier() == tier){
                t.add(items.get(i));
            }
        }
        
        return t;
    }
}
