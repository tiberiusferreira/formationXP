package fr.excilys.formation.bowliwood;

/**
 * Created by tiberio on 09/12/2016.
 */
public class Player {
    /**
     * Name of the player.
     */
    private String name;

    /**
     * How many rolls have been played yet.
     */
    private int currentRoll = 0;

    /**
     * History of rolls.
     */
    private int[] rolls = new int[21];

    /**
     * Get the name of the player.
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of a player.
     * @param newName The new name of the player
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Save the value of a roll.
     * @param pins the value to save
     */
    public void roll(final int pins){
        rolls[currentRoll++] = pins;
    }

    /**
     * Calculate the score of a player.
     * @return the current score of a player
     */
    public int getScore() {
        int frameIndex = 0;
        int score = 0;
        for (int frame = 0; frame < Game.NB_ROLL; frame++) {
            if (isStrike(frameIndex)) {
                score += Game.NB_PIN + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += Game.NB_PIN + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    /**
     * Checks if the frame given corresponds to a strike
     * @param frameIndex
     * @return True if strike, false if not
     */
    private boolean isStrike(final int frameIndex) {
        return rolls[frameIndex] == Game.NB_PIN;
    }
    /**
     * Returns the bonus of the strike which corresponds to the next two frames
     * @param frameIndex
     * @return the bonus
     */
    private int strikeBonus(final int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isSpare(final int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == Game.NB_PIN;
    }

    private int spareBonus(final int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int sumOfBallsInFrame(final int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }
}
