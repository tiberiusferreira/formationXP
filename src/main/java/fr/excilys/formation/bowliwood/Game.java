package fr.excilys.formation.bowliwood;

/**
 * Created by tiberio on 09/12/2016.
 */
public class Game {
    Player player1 = new Player("Tiberio");
    Player player2 = new Player("Fernando");
    Player[] players = {player1, player2};

    void printScore(){
        System.out.println("Score:");
        for (Player player: players){
            System.out.print("  Player: " + player.name);
            System.out.println(" " + player.getScore());
        }
    }




    public static void main(String [] args)
    {
        Game game = new Game();
        game.printScore();
    }
}
