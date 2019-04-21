package Game;
import Interfaces.*;
import Items.*;
import NPCs.*;

/**
 *
 * @author xg6856vd
 */
public class GameBoard {
    
    public static Hero hero = new Hero();
    
    public static void main(String[] arg){
        
        //add way to enter player name
        
        //instantiate npcs
        NpcInterface goblin = new Enemy(10,1,1, "Goblin");
        ItemInterface copperBp = new Armor(1,1,10, "Copper Breastplate");
        ItemInterface imbaSword = new Weapon(1000,1000,1000, "Sword of One Thousand Truths");
        
        
        //testing attacks - need to remove enemy when hp reaches 0
        beginCombat(goblin);
        
        //testing inventory and equipment - seems to work as intended
        hero.addToInventory(copperBp);
        hero.equipItem(copperBp);
        System.out.println(hero.getStr());
        hero.unequipItem(copperBp);
        System.out.println(hero.getStr());
        
        hero.equipItem(copperBp);
        System.out.println(hero.getStr());
        
        hero.equipItem(copperBp);
        System.out.println(hero.getStr());
        
        hero.addToInventory(imbaSword);
        hero.equipItem(imbaSword);
        System.out.println(hero.getStr());
        System.out.println(hero.getEquippedWeapon().getName());
        
        //may need to alter this method a bit
        System.out.println(hero.getInventory());
        
    }
    
    
    
    
    
    public static void beginCombat(NpcInterface enemy){
        do{
            hero.attack(enemy);
            if(enemy.isKilled()){
                break;
            }
            enemy.attack(hero);
        }
        while(!hero.isKilled());
        if(hero.isKilled()){
            //game over
        }
        else{
            //enemy is dead
            System.out.println("The " + enemy.getName() + " has been defeated.");
            //enemy = null;
        }
    }
}
