package fr.excilys.formation.bowliwood;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;
/**
 * Created by tiberio on 09/12/2016.
 */
public class PlayerTest {
    Player test_player = new Player("test");
    @Test
    public void testPinsHit(){
        Random rand = new Random(10);
        int pinsLeft = rand.nextInt(10);
        int result = test_player.pinsHit(pinsLeft);
        boolean validRange = (result>=0) && (result<=pinsLeft);
        assertTrue("The number of pins hit is between 0 and 10", validRange);
    }
}
