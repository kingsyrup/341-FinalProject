package Events;

import Game.Combat;
import Helpers.Menu;
import Interfaces.EventInterface;
import NPCs.Enemy;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */
public class Dragon implements EventInterface {
    
    private final String name ="Dragon Encounter";
    private final String description = "You stumble upon a goblin gathering "
            + "water at a stream.";
    private final Menu choices = new Menu();
    private Scanner console = new Scanner(System.in);
    private int baseHp = 100;
    private Enemy enemy = new Enemy(baseHp,10,10,"Dragon");
    private boolean flag = false;
    private boolean hasKey = false;
    
    public Dragon() {
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }
    
    @Override
    public void choices() {
        int userSelection = -1;

        if (!flag) {
            choices.addItem("Attack the " + enemy.getName());
            choices.addItem("Attempt to befriend the " + enemy.getName());
            choices.addItem("Sneak past the " + enemy.getName());

            do {
                System.out.print(choices.showMenu());

                userSelection = console.nextInt();
                //switch for choice cases
                switch (userSelection) {
                    //attack
                    case 1:
                        Combat.beginCombat(enemy, baseHp);
                        enemy = null;
                        Game.GameBoard.locations.get(Game.Overworld.userSelection - 1).removeEvent(this);
                        flag = true;
                        break;
                    case 2:
                        if (Combat.chance(25)) {
                            flag = true;
                        } else {
                            Combat.beginCombat(enemy, baseHp);
                            enemy = null;
                            flag = true;
                        }
                        break;
                    case 3:
                        if (Combat.chance(45)) {
                            System.out.println("You snuck past the " + enemy.getName());
                            flag = true;
                        } else {
                            Combat.beginCombat(enemy, baseHp);
                            flag = true;
                        }
                        break;
                    default:
                        break;
                }

            } while (!flag);
            if (hasKey && userSelection != 4) {
                System.out.println("You found a key.");
                hasKey = false;
                Game.GameBoard.multiplier++;
            }
        }
    }
    
    @Override
    public void hasKey(boolean hasKey){
        this.hasKey = hasKey;
    }
}
