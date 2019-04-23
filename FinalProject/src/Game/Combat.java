/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import static Game.GameBoard.*;
import Interfaces.ItemInterface;
import Interfaces.NpcInterface;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author xg6856vd
 */
public class Combat {
    
    public static void beginCombat(NpcInterface enemy){
        System.out.println();
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
            victory(enemy);
            //enemy = null;
        }
    }
    
    //enemy is defeated
    public static void victory(NpcInterface enemy){
        
        //25% chance for enemy to drop loot
        Random random = new Random();
        double r = random.nextDouble();
        boolean dropsLoot;
        dropsLoot = r < 1.0/4.0;
        
        if(dropsLoot == true){
            //Enemy drops random item from current tier - based on difficulty multiplier
            Random rng = new Random();
            ArrayList<ItemInterface> loot = items.tier(multiplier);
            int modifier = (rng.nextInt(loot.size()));
            ItemInterface item = loot.get(modifier);


            //Add item to player's inventory and remove from global item list
            // ensures items are unique
            hero.addToInventory(item);
            System.out.println("The " + enemy.getName() + " dropped a " + item.getName()
                    + ".");
            items.removeItem(item);
        }
    }
}
