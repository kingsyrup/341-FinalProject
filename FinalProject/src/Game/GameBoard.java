package Game;
import Interfaces.*;
import Items.*;
import NPCs.*;
import Events.*;
import Locations.*;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */

//                     WOULD LIKE TO SCALE EVENTS/ENEMIES BASED ON
//                     HOW MANY KEYS HAVE BEEN FOUND


public class GameBoard {
    
    public static Hero hero = new Hero();
    
    public static void main(String[] arg){
        
        //add way to enter player name
        //hero.setName("name");
        
        Scanner console = new Scanner(System.in);
        
        //instantiate npcs
        NpcInterface goblin = new Enemy(10,1,1, "Goblin");
        NpcInterface vampire = new Enemy(100,3,4, "Vampire");
        
        //instantiate items
        ItemInterface copperBp = new Armor(1,1,10, "Copper Breastplate");
        ItemInterface imbaSword = new Weapon(1000,1000,1000, "Sword of One Thousand Truths");
        
        //instantiate events and locations
        EventInterface goblinAttack = new GoblinAttacks();
        LocationInterface startingZone = new StartingArea();
        startingZone.addEvent(goblinAttack);
        
        //testing attacks - need to remove enemy when hp reaches 0
        //might add enemies in event class instead of main - would solve above problem
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
        //hero.equipItem(imbaSword);
        //System.out.println(hero.getStr());
        //System.out.println(hero.getEquippedWeapon().getName());
        hero.getInventory();
        
        
        beginCombat(vampire);
        
        //test location and events
        System.out.println("\n" + startingZone.description());
        System.out.println(startingZone.getEvents().showMenu());
        
    }
    
    
    
    
    
    public static void beginCombat(NpcInterface enemy){
        do{
            //possibly add combat menu here to start each round of fighting
            hero.attack(enemy);
            if(enemy.isKilled()){
                break;
            }
            enemy.attack(hero);
        }
        while(!hero.isKilled());
        if(hero.isKilled()){
            //game over
            System.out.println("------GAME OVER------");
            System.out.println("You were slain by a " + enemy.getName() + ".");
        }
        else{
            //enemy is dead
            System.out.println("The " + enemy.getName() + " has been defeated.");
            //enemy = null;
        }
    }
}
