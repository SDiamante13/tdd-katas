package tech.pathtoprogramming.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Integer> frames = new ArrayList<>();

    public void roll(int pins) {
        if (lastTwoFramesAddUpToTen()) {
            int index = frames.size() - 1;
            int currentValue = frames.get(index);
            frames.set(index, currentValue + pins);
        }
        frames.add(pins);
    }

    private boolean lastTwoFramesAddUpToTen() {
        int index = frames.size() - 1;
        return frames.size() >= 2 &&
                frames.get(index) + frames.get(index - 1) == 10;
    }

    public int score() {
        return frames.stream()
                .mapToInt(i -> i)
                .sum();
    }
}
