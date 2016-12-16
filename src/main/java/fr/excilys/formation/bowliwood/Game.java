package fr.excilys.formation.bowliwood;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

/**
 * Created by tiberio on 09/12/2016.
 */
public class Game {
    Player player1 = new Player();
    Player player2 = new Player();
    Player[] players = {player1, player2};
    void printRules(){
        System.out.println("Please, follow this link to continue: http://www.pba.com/Resources/Bowling101 ");
    }
    void printMenu(){
        int i = -1;
        while (i == -1){
            System.out.println("Welcome the this amazing bowling game! ");
            System.out.println("Please type 0 to the see the rules");
            System.out.println("Please type 1 to start a game");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try{
                i = Integer.parseInt(br.readLine());
            }catch(Exception nfe){
                System.err.println("Invalid Format!");
            }
            if (i == 0){
                printRules();
                i = -1;
            }
            if (i == 1){
                for (Player player: players) {
                    getPlayerNames(player);
                }
                System.out.println("Let's start the game, folks!");
                return;
            }
        }
    }
    void getPlayerNames(Player player){
        System.out.println("Please enter the name of the player");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        try{
            name = br.readLine();
        }catch(Exception nfe){
            System.err.println("Invalid Format!");
        }
        player.name = name;
    }
    void printScore(){
        System.out.println("Score:");
        for (Player player: players){
            System.out.print("  Player: " + player.name);
            System.out.println(" " + player.getScore());
        }
    }

    int getRoll(){
        int pins = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            pins = Integer.parseInt(br.readLine());
            if (pins == -1) {
                exit(1);
            }
            if (pins == -2) {
                printRules();
            }
        } catch (Exception nfe) {
            System.err.println("Invalid Format!");
        }
        return pins;
    }
    void playFrame(){
        for (Player player: players) {
            int pins1 = -1;
            while(pins1<0 || pins1>10){
                System.out.println(player.name + " it's your turn! Please insert the value of pins you hit for the first throw, -1 to quit or -2 to view the rules:");
                pins1 = getRoll();
            }
            player.roll(pins1);
            if (pins1 == 10){
                printStrike();
                continue;
            }

            int pins2 = -1;
            while (pins2 < 0 || pins2 > 10 - pins1) {
                System.out.println(player.name + " it's your turn! Please insert the value of pins you hit for the second throw, -1 to quit or -2 to view the rules:");
                pins2 = getRoll();
            }
            player.roll(pins2);
            if (pins1 + pins2 == 10) {
                printSpare();
            }
        }
    }

    public static void main(final String[] args) {
        Game game = new Game();
        game.printMenu();
        game.printScore();
        for (int i = 0; i < 10; i++) {
            game.playFrame();
            game.printScore();
        }
        System.out.println("End of Game!");
    }

    void printStrike(){
        System.out.println("   _____   _______   _____    _____   _  __  ______     _   _   _   _ ");
        System.out.println("  / ____| |__   __| |  __ \\  |_   _| | |/ / |  ____|   | | | | | | | |");
        System.out.println(" | (___      | |    | |__) |   | |   | ' /  | |__      | | | | | | | |");
        System.out.println("  \\___ \\     | |    |  _  /    | |   |  <   |  __|     | | | | | | | |");
        System.out.println("  ____) |    | |    | | \\ \\   _| |_  | . \\  | |____    |_| |_| |_| |_|");
        System.out.println(" |_____/     |_|    |_|  \\_\\ |_____| |_|\\_\\ |______|   (_) (_) (_) (_)");
        System.out.println("                                                                       ");
    }
    void printSpare(){
        System.out.println("   _____   _____               _____    ______     _   _   _   _ ");
        System.out.println("  / ____| |  __ \\      /\\     |  __ \\  |  ____|   | | | | | | | |");
        System.out.println(" | (___   | |__) |    /  \\    | |__) | | |__      | | | | | | | |");
        System.out.println("  \\___ \\  |  ___/    / /\\ \\   |  _  /  |  __|     | | | | | | | |");
        System.out.println("  ____) | | |       / ____ \\  | | \\ \\  | |____    |_| |_| |_| |_|");
        System.out.println(" |_____/  |_|      /_/    \\_\\ |_|  \\_\\ |______|   (_) (_) (_) (_)");
        System.out.println("                                                                       ");
    }
}
