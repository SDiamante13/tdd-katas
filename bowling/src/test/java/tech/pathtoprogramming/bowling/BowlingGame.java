package tech.pathtoprogramming.bowling;

public class BowlingGame {

    private final int[] rolls = new int[21];
    private int rollCount;

    public void roll(int pins) {
        rolls[rollCount++] = pins;
    }

    public int score() {
        int total = 0;
        int roll = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (rolls[roll] == 10) {
                total += 10 + rolls[roll + 1] + rolls[roll + 2];
                roll++;
            } else if (rolls[roll] + rolls[roll + 1] == 10) {
                total += 10 + rolls[roll + 2];
                roll += 2;
            } else {
                total += rolls[roll] + rolls[roll + 1];
                roll += 2;
            }
        }
        return total;
    }
}
