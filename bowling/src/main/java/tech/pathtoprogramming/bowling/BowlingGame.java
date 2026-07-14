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
                total += 10 + rolls.get(roll + 1) + rolls.get(roll + 2);
                roll++;
            } else if (isSpare(roll)) {
                total += 10 + rolls.get(roll + 2);
                roll += 2;
            } else {
                total += rolls.get(roll) + rolls.get(roll + 1);
                roll += 2;
            }
        }
        return total;
    }

    private boolean isStrike(int roll) {
        return rolls.get(roll) == 10;
    }

    private boolean isSpare(int roll) {
        return rolls.get(roll) + rolls.get(roll + 1) == 10;
    }
}
