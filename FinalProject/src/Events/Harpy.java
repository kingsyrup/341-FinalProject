/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

import Game.Combat;
import Game.Menu;
import Interfaces.EventInterface;
import NPCs.Enemy;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */
public class Harpy implements EventInterface {
    
    private final String name ="Harpy Encounter";
    private final String description = "You stumble upon a goblin gathering "
            + "water at a stream.";
    private final Menu choices = new Menu();
    private Scanner console = new Scanner(System.in);
    private Enemy goblin = new Enemy(10,1,1,"Harpy");
    private boolean deadFlag = false;
    private boolean friendFlag = false;
    
    public Harpy() {
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }
    
    //need a different return type
    @Override
    public void choices(){
        int userSelection = -1;
        
        //Goblin is alive
        if(!deadFlag){
            choices.addItem("Attack the goblin"); //beginCombat
            choices.addItem("Attempt to befriend the goblin");  //charisma stat?
            choices.addItem("Sneak past the goblin"); //dexterity stat?
            choices.addItem("Flee"); //spd stat?
            System.out.print(choices.showMenu());

            userSelection = console.nextInt();
            //switch for choice cases
            switch(userSelection){
                //attack the goblin
                case 1:
                    //multiplier (based on how many keys have been found)
                    int multiplier = Game.GameBoard.multiplier;
                    
                    //if multiplier has not been applied, apply it
                    if(goblin.getHp() / multiplier != 10){
                        goblin.setDef(goblin.getDef() * multiplier);
                        goblin.setStr(goblin.getStr() * multiplier);
                        goblin.setHp(goblin.getHp() * multiplier);
                    }
                    Combat.beginCombat(goblin);
                    goblin = null;
                    deadFlag = true;
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }
        //return choices;
    }
}
