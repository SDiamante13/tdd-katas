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
        int rollIndex = 0;
        for (int frameNumber = 0; frameNumber < 10; frameNumber++) {
            Frame frame = Frame.fromRolls(rolls, rollIndex);
            total += frame.score(rolls, rollIndex);
            rollIndex += frame.rollsConsumed();
        }
        return total;
    }
}

