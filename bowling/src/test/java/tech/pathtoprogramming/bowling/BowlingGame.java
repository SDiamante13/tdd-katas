package tech.pathtoprogramming.bowling;

public class BowlingGame {
    private int score;

    public void roll(int pins) {
        score += pins;
    }

    public int score() {
        return score;
    }
}
