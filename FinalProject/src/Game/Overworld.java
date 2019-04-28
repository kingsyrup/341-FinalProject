package Game;

import Helpers.Menu;
import static Game.GameBoard.*;
import Locations.FinalArea;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */

//Menu that lists all the game locations
public class Overworld {
    
    private static final Menu LOCATION_MENU = new Menu();
    public static int userSelection = -1;
    private static final Scanner CONSOLE = new Scanner(System.in);
    
    public static void getLocations(){
        
        if(LOCATION_MENU.size() == 0){
            for(int i = 0; i < locations.size(); i++){
                LOCATION_MENU.addItem(locations.get(i).name());
            }
            LOCATION_MENU.addItem("Check inventory");
            LOCATION_MENU.addItem("Exit Game");
        }

        do{
            //unlock final area when conditions are met
            if(multiplier == 8 && LOCATION_MENU.size() == 10){
                locations.add(0,new FinalArea());
                LOCATION_MENU.addItem(0,locations.get(0).name());
                break;
            }
        System.out.println("\n----------OVERWORLD----------");
        System.out.println("Where will you go?");
        System.out.print(LOCATION_MENU.showMenu());
        userSelection = CONSOLE.nextInt();
            switch(userSelection){
                case 1:
                    System.out.println();
                    System.out.println(locations.get(0).description());
                    locations.get(0).listEvents();
                    break;
                case 2:
                    System.out.println();
                    System.out.println(locations.get(1).description());
                    locations.get(1).listEvents();
                    break;
                case 3:
                    System.out.println();
                    System.out.println(locations.get(2).description());
                    locations.get(2).listEvents();
                    break;
                case 4:
                    System.out.println();
                    System.out.println(locations.get(3).description());
                    locations.get(3).listEvents();
                    break;
                case 5:
                    System.out.println();
                    System.out.println(locations.get(4).description());
                    locations.get(4).listEvents();
                    break;
                case 6:
                    System.out.println();
                    System.out.println(locations.get(5).description());
                    locations.get(5).listEvents();
                    break;
                case 7:
                    System.out.println();
                    System.out.println(locations.get(6).description());
                    locations.get(6).listEvents();
                    break;
                case 8:
                    System.out.println();
                    System.out.println(locations.get(7).description());
                    locations.get(7).listEvents();
                    break;
                case 9:
                    hero.getInventory();
                    break;
                case 10:
                    System.out.println();
                    break;
                default:
                    break;
            }
        }
        while(userSelection != 10);
        
        if(LOCATION_MENU.size() == 11){
        //final area has been unlocked.
        do{
        System.out.println("\n----------OVERWORLD----------");
        System.out.println("Where will you go?");
        System.out.print(LOCATION_MENU.showMenu());
        userSelection = CONSOLE.nextInt();
            switch(userSelection){
                case 1:
                    System.out.println(locations.get(0).description());
                    locations.get(0).listEvents();
                    break;
                case 2:
                    System.out.println(locations.get(1).description());
                    locations.get(1).listEvents();
                    break;
                case 3:
                    System.out.println(locations.get(2).description());
                    locations.get(2).listEvents();
                    break;
                case 4:
                    System.out.println(locations.get(3).description());
                    locations.get(3).listEvents();
                    break;
                case 5:
                    System.out.println(locations.get(4).description());
                    locations.get(4).listEvents();
                    break;
                case 6:
                    System.out.println(locations.get(5).description());
                    locations.get(5).listEvents();
                    break;
                case 7:
                    System.out.println(locations.get(6).description());
                    locations.get(6).listEvents();
                    break;
                case 8:
                    System.out.println(locations.get(7).description());
                    locations.get(7).listEvents();
                    break;
                case 9:
                    System.out.println(locations.get(8).description());
                    locations.get(8).listEvents();
                    break;
                case 10:
                    hero.getInventory();
                    break;
                case 11:
                    System.out.println();
                    break;
                default:
                    break;
            }
        }
        while(userSelection != 11);
    }
    }
    
}
