package Game;

import Helpers.Menu;
import static Game.GameBoard.hero;
import java.util.Scanner;

/**
 *
 * @author xg6856vd
 */

//main menu  - option to start new game or load saved game

public class MainMenu{
    
    private static Menu mainMenu = new Menu();
    private static int userSelection = -1;
    private static Scanner console = new Scanner(System.in);
    
    public MainMenu(){
        
    }
    
    public static void show(){
        
        mainMenu.addItem("Start New Game");
        mainMenu.addItem("Exit");
        
        do{
        System.out.println("----------MAIN MENU----------");
        System.out.print(mainMenu.showMenu());
        userSelection = console.nextInt();
            switch(userSelection){
                //new game
                case 1:
                    //initialize locations and events
                    Initialize.init();
                    
                    //prompt for character name
                    System.out.println("\nEnter a name for your character.");
                    hero.setName(console.next());
                    
                    //start game
                    Overworld.getLocations();
                    break;
                //Exit    
                case 2:
                    userSelection = -2;
                    break;
                default:
                    break;
            }
        }
        while(userSelection != -2);
    }
}
