/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;
import Interfaces.NpcInterface;
import NPCs.*;
import java.util.Random;

/**
 *
 * @author xg6856vd
 */
public class GameBoard {
    
    public static void main(String[] arg){
        
        //instantiate npcs and player
        NpcInterface goblin = new Goblin();
        NpcInterface hero = new Hero();
        
        
        //testing attacks - need to remove enemy when hp reaches 0
        System.out.println("You attack the goblin");
        System.out.println(attack(hero, goblin));
        System.out.println(goblin.getHp());
        
        System.out.println("The goblin attacks!");
        System.out.println(attack(goblin, hero));
        System.out.println(hero.getHp());
        
        System.out.println("You attack the goblin");
        System.out.println(attack(hero, goblin));
        System.out.println(goblin.getHp());
        
        System.out.println("The goblin attacks!");
        System.out.println(attack(goblin, hero));
        System.out.println(hero.getHp());
        System.out.println("You attack the goblin");
        System.out.println(attack(hero, goblin));
        System.out.println(goblin.getHp());
        
        System.out.println("The goblin attacks!");
        System.out.println(attack(goblin, hero));
        System.out.println(hero.getHp());
    }
    

    //simple attack class - pretty sure this needs to be overhauled
    public static String attack(NpcInterface attacker, NpcInterface defender){
        int attack = attacker.getStr() * diceRoll();
        int def = defender.getDef();
        
        int damage = attack - def;
        if (damage > 0){
            int hp = defender.getHp() - damage;

            if(hp <= 0){
                String name = defender.name();
                return "The " + name + " took " + damage + " damage and was killed";
            }
            else{
                defender.setHp(hp);
                return "The " + defender.name() + " took " + damage + " damage";
            }
        }
        else{
            return "No damage was dealt!";
        }
    }
    
    //dice roll to randomize attack damage, modifiers are 1-3, might add crit chance
    public static final int diceRoll(){
        Random rng = new Random();
        int modifier = (rng.nextInt(3) + 1);
        return modifier;
    }
}
