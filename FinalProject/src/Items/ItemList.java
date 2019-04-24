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
        items.add(new Armor(0,2,15,"Copper Breasplate",1));
        items.add(new Armor(0,1,10,"Copper Greaves",1));
        items.add(new Armor(0,2*2,15*2,"Bronze Breasplate",2));
        items.add(new Armor(0,1*2,10*2,"Bronze Greaves",2));
        items.add(new Armor(0,2*3,15*3,"Silver Breasplate",3));
        items.add(new Armor(0,1*3,10*3,"Silver Greaves",3));
        items.add(new Armor(0,2*4,15*4,"Gold Breasplate",4));
        items.add(new Armor(0,1*4,10*4,"Gold Greaves",4));
        items.add(new Armor(0,2*5,15*5,"Platinum Breasplate",5));
        items.add(new Armor(0,1*5,10*5,"Platinum Greaves",5));
        items.add(new Armor(0,2*6,15*6,"Adamantium Breasplate",6));
        items.add(new Armor(0,1*6,10*6,"Adamantium Greaves",6));
        items.add(new Armor(0,2*6,15*6,"Palladium Breasplate",7));
        items.add(new Armor(0,1*6,10*6,"Palladium Greaves",7));
        items.add(new Armor(0,2*6,15*6,"Vibranium Breasplate",8));
        
        //Weapon
        items.add(new Weapon(3,0,0,"Dagger",1));
        items.add(new Weapon(2,0,0,"Blow Dart",1));
        items.add(new Weapon(3,0,0,"Longsword",2));
        items.add(new Weapon(2,0,0,"Rapier",2));
        items.add(new Weapon(3,0,0,"Broadsword",3));
        items.add(new Weapon(2,0,0,"Greatsword",3));
        items.add(new Weapon(3,0,0,"Halberd",4));
        items.add(new Weapon(2,0,0,"Mace",4));
        items.add(new Weapon(3,0,0,"Morningstar",5));
        items.add(new Weapon(2,0,0,"Battle Axe",5));
        items.add(new Weapon(3,0,0,"Masamune",6));
        items.add(new Weapon(2,0,0,"Muramasa",6));
        items.add(new Weapon(3,0,0,"Frostmourne",7));
        items.add(new Weapon(2,0,0,"Thunderfury",7));
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
