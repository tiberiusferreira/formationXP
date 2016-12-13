package fr.excilys.formation.bowliwood;

/**
 * Created by tiberio on 09/12/2016.
 */
public class Player {
    public String name;
    private int currentRoll = 0;
    private int rolls[] = new int[21];

    public void roll(int pins){
        rolls[currentRoll++] = pins;
    }

    public int getScore(){
        int frameIndex = 0;
        int score = 0;
        for (int frame=0 ; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex+1] + rolls[frameIndex+2];
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex]+rolls[frameIndex+1] == 10;
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex+2];
    }

    private int sumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex+1];
    }
}
