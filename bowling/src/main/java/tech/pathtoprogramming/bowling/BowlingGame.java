package tech.pathtoprogramming.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private final List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        int total = 0;
        int roll = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(roll)) {
                total += strikeScore(roll);
                roll++;
            } else if (isSpare(roll)) {
                total += spareScore(roll);
                roll += 2;
            } else {
                total += openFrameScore(roll);
                roll += 2;
            }
        }
        return total;
    }

    private int strikeScore(int roll) {
        return 10 + rolls.get(roll + 1) + rolls.get(roll + 2);
    }

    private int spareScore(int roll) {
        return 10 + rolls.get(roll + 2);
    }

    private int openFrameScore(int roll) {
        return rolls.get(roll) + rolls.get(roll + 1);
    }

    private boolean isStrike(int roll) {
        return rolls.get(roll) == 10;
    }

    private boolean isSpare(int roll) {
        return rolls.get(roll) + rolls.get(roll + 1) == 10;
    }
}
