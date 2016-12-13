package fr.excilys.formation.bowliwood;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by tiberio on 09/12/2016.
 */
public class PlayerTest {
    Player p = new Player();

    private void rollSeveral(int nTimes, int pins){
        for (int i = 0; i < nTimes; i++)
            p.roll(pins);
    }

    private void rollSpare(){
        p.roll(5);
        p.roll(5);
    }

    private void rollStrike(){
        p.roll(10);
    }

    @Test
    public void testNullScore(){
        rollSeveral(20, 0);
        assertEquals(p.getScore(10), 0);
    }

    @Test
    public void testAllOnes(){
        rollSeveral(20, 1);
        assertEquals(p.getScore(10), 20);
    }

    @Test
    public void testRollSpare(){
        rollSpare();
        p.roll(2);
        rollSeveral(17, 0);
        assertEquals(p.getScore(10), 14);
    }

    @Test
    public void testOneStrike(){
        rollStrike();
        p.roll(2);
        p.roll(2);
        rollSeveral(16, 0);
        assertEquals(p.getScore(10), 18);
    }

    @Test
    public void testPerfectGame(){
        rollSeveral(12, 10);
        assertEquals(p.getScore(10), 300);
    }
}
