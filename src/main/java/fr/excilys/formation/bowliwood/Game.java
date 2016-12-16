package fr.excilys.formation.bowliwood;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.exit;

/**
 * Created by tiberio on 09/12/2016.
 */
public class Game {
    /**
     * Number of pins on the row.
     */
    static final int NB_PIN = 10;

    /**
     * Number of turn in a game.
     */
    static final int NB_ROLL = 10;

    /**@ List of player competing.
     */
    private Player[] players;

    /** Constructor for n players.
     * @param n the number of players
     */
    Game(final int n) {
        this.players = new Player[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Player();
        }
    }

    /**
     * Display the game menu.
     */
    private void printMenu() {
        int i = -1;
        while (i == -1) {
            System.out.println("Welcome the this amazing bowling game! ");
            System.out.println("Please type 0 to the see the rules");
            System.out.println("Please type 1 to start a game");
            BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(System.in));
            try {
                i = Integer.parseInt(br.readLine());
            } catch (Exception nfe) {
                System.err.println("Invalid Format!");
            }
            if (i == 0) {
                printRules();
                i = -1;
            }
            if (i == 1) {
                for (Player player: players) {
                    setPlayerNames(player);
                }
                System.out.println("Let's start the game, folks!");
                return;
            }
        }
    }

    /**
     * Displays the rules on the screen.
     */
    private void printRules() {
        System.out.println("Please, follow this link to continue: http://www.pba.com/Resources/Bowling101 ");
    }



    /**
     * Set the name of a player from the command line.
     * @param player the player to get the name of
     */
    private void setPlayerNames(final Player player) {
        System.out.println("Please enter the name of the player");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = null;
        try {
            name = br.readLine();
        } catch (Exception nfe) {
            System.err.println("Invalid Format!");
        }
        player.setName(name);
    }
    /**
     * Display the score of the players.
     */
    private void printScore() {
        System.out.println("Score:");
        for (Player player: players) {
            System.out.print("  Player: " + player.getName());
            System.out.println(" " + player.getScore());
        }
    }

    /**
     * Rolls a ball.
     * @return number of pins rolled
     */
    private int getRoll() {
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
            if (pins == -3) {
                printScore();
            }
        } catch (Exception nfe) {
            System.err.println("Invalid Format!");
        }
        return pins;
    }

    /**
     * Make each player play.
     */
    private void playFrame() {
        for (Player player: players) {
            int pins1 = -1;
            while (pins1 < 0 || pins1 > Game.NB_PIN) {
                System.out.println(player.getName() +
                    " it's your turn! Please insert the value of pins you hit for the first throw, -1 to quit, -2 to view the rules or -3 to see the score:");
                pins1 = getRoll();
            }
            player.roll(pins1);
            if (pins1 == Game.NB_PIN){
                printStrike();
                continue;
            }

            int pins2 = -1;
            while (pins2 < 0 || pins2 > Game.NB_PIN - pins1) {
                System.out.println(player.getName() +
                        " it's your turn! Please insert the value of pins you hit for the first throw, -1 to quit, -2 to view the rules or -3 to see the score:");
                pins2 = getRoll();
            }
            player.roll(pins2);
            if (pins1 + pins2 == Game.NB_PIN) {
                printSpare();
            }
        }
    }

    /**
     * Game entry point.
     * @param args Commandline arguments
     */
    public static void main(final String[] args) {
        Game game = new Game(2);
        game.printMenu();
        game.printScore();
        for (int i = 0; i < Game.NB_ROLL; i++) {
            game.playFrame();
            game.printScore();
        }
        System.out.println("End of Game!");
    }

    /**
     * Display Strike on the screen.
     */
    private void printStrike() {
        System.out.println("   _____   _______   _____    _____   _  __  ______     _   _   _   _ ");
        System.out.println("  / ____| |__   __| |  __ \\  |_   _| | |/ / |  ____|   | | | | | | | |");
        System.out.println(" | (___      | |    | |__) |   | |   | ' /  | |__      | | | | | | | |");
        System.out.println("  \\___ \\     | |    |  _  /    | |   |  <   |  __|     | | | | | | | |");
        System.out.println("  ____) |    | |    | | \\ \\   _| |_  | . \\  | |____    |_| |_| |_| |_|");
        System.out.println(" |_____/     |_|    |_|  \\_\\ |_____| |_|\\_\\ |______|   (_) (_) (_) (_)");
        System.out.println("                                                                       ");
    }

    /**
     * Display Spare on the screen.
     */
    private void printSpare() {
        System.out.println("   _____   _____               _____    ______     _   _   _   _ ");
        System.out.println("  / ____| |  __ \\      /\\     |  __ \\  |  ____|   | | | | | | | |");
        System.out.println(" | (___   | |__) |    /  \\    | |__) | | |__      | | | | | | | |");
        System.out.println("  \\___ \\  |  ___/    / /\\ \\   |  _  /  |  __|     | | | | | | | |");
        System.out.println("  ____) | | |       / ____ \\  | | \\ \\  | |____    |_| |_| |_| |_|");
        System.out.println(" |_____/  |_|      /_/    \\_\\ |_|  \\_\\ |______|   (_) (_) (_) (_)");
        System.out.println("                                                                       ");
    }
}
