package fr.excilys.formation.bowliwood;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tiberio on 09/12/2016.
 */
public class Game {
    Player player1 = new Player();
    Player player2 = new Player();
    Player[] players = {player1, player2};

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
                System.out.println("Please, follow this link to continue: http://www.pba.com/Resources/Bowling101 ");
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
            System.out.println(" " + player.getScore(0));
        }
    }

    public static void main(String [] args)
    {
        Game game = new Game();
        game.printMenu();
        game.printScore();
    }
}
