package fr.excilys.formation.bowliwood;

import java.util.Random;

/**
 * Created by tiberio on 09/12/2016.
 */
public class Player {
    public String name;
    private int score = 0;

    Player(String name){
        this.name = name;
    }

    public static void main(String [] args)
    {
        System.out.println("Hello!");
    }

    public int getScore(){
        return this.score;
    }

    public int pinsHit( int pinsLeft ){
        Random rand = new Random(pinsLeft);
        return rand.nextInt(pinsLeft);
    }






}
