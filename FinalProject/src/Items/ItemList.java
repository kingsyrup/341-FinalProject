package Items;

import Interfaces.ItemInterface;
import java.util.ArrayList;

/**
 *
 * @author xg6856vd
 */

//Items that can be found in the game, divided into tiers
public final class ItemList {
    
    private ArrayList<ItemInterface> items = new ArrayList();
   
    public ItemList(){
        this.generateItems();
    }
    
    public ArrayList<ItemInterface> generateItems(){
        //Armor
        items.add(new Armor(2,5,30,"Copper Breasplate",1));
        items.add(new Armor(3,3,30,"Copper Greaves",1));
        items.add(new Armor(5,5,45,"Spaulders of Valanor",1));
        items.add(new Armor(4,9,55,"Bronze Breasplate",2));
        items.add(new Armor(7,5,40,"Bronze Greaves",2));
        items.add(new Armor(7,9,55,"Gorash Sabatons",2));
        items.add(new Armor(5,14,85,"Silver Breasplate",3));
        items.add(new Armor(11,9,60,"Silver Greaves",3));
        items.add(new Armor(15,23,100,"Pauldrons of Everia",3));
        items.add(new Armor(9,23,100,"Gold Breasplate",4));
        items.add(new Armor(15,14,75,"Gold Greaves",4));
        items.add(new Armor(15,33,135,"Holjin Shield",4));
        items.add(new Armor(12,33,135,"Platinum Breasplate",5));
        items.add(new Armor(15,23,95,"Platinum Greaves",5));
        items.add(new Armor(24,46,170,"Boraji Spaulders",5));
        items.add(new Armor(15,46,170,"Adamantium Breasplate",6));
        items.add(new Armor(24,33,135,"Adamantium Greaves",6));
        items.add(new Armor(35,65,220,"Kiljani Sabatons",6));
        items.add(new Armor(24,65,220,"Palladium Breasplate",7));
        items.add(new Armor(35,46,185,"Palladium Greaves",7));
        items.add(new Armor(45,95,300,"Pauldrons of Lormir",7));
        items.add(new Armor(55,150,350,"Vibranium Breasplate",8));
        
        //Weapon
        items.add(new Weapon(3,1,10,"Dagger",1));
        items.add(new Weapon(4,0,5,"Blow Dart",1));
        items.add(new Weapon(6,2,25,"Felblade",1));
        items.add(new Weapon(6,1,25,"Longsword",2));
        items.add(new Weapon(5,2,15,"Rapier",2));
        items.add(new Weapon(9,3,35,"Fangor",2));
        items.add(new Weapon(7,3,35,"Broadsword",3));
        items.add(new Weapon(9,1,15,"Greatsword",3));
        items.add(new Weapon(14,6,45,"Fenrir",3));
        items.add(new Weapon(14,0,0,"Halberd",4));
        items.add(new Weapon(11,0,15,"Mace",4));
        items.add(new Weapon(20,10,65,"Gendrel Blade",4));
        items.add(new Weapon(14,0,30,"Morningstar",5));
        items.add(new Weapon(20,0,0,"Battle Axe",5));
        items.add(new Weapon(35,4,150,"Mohramir's Pike",5));
        items.add(new Weapon(35,4,0,"Masamune",6));
        items.add(new Weapon(35,0,150,"Muramasa",6));
        items.add(new Weapon(40,25,250,"Valriel Hammer",6));
        items.add(new Weapon(40,10,225,"Frostmourne",7));
        items.add(new Weapon(35,25,250,"Thunderfury",7));
        items.add(new Weapon(55,40,350,"Pemrook Poleaxe",7));
        items.add(new Weapon(1000,1000,1000, "Golden Sword",100));
        
        //Another category for consumables?
        
        return items;
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
