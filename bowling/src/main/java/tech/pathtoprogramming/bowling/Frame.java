package tech.pathtoprogramming.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private final List<Integer> pins;

    public Frame(List<Integer> pins) {
        this.pins = new ArrayList<>(pins);
    }

    public static Frame fromRolls(List<Integer> rolls, int startIndex) {
        int first = rolls.get(startIndex);
        if (first == 10) {
            // Strike - consumes 1 roll
            return new Frame(List.of(first));
        }
        int second = rolls.get(startIndex + 1);
        if (first + second == 10) {
            // Spare - consumes 2 rolls
            return new Frame(List.of(first, second));
        }
        // Open frame
        return new Frame(List.of(first, second));
    }

    public boolean isStrike() {
        return pins.size() == 1 && pins.get(0) == 10;
    }

    public boolean isSpare() {
        return pins.size() == 2 && pins.get(0) + pins.get(1) == 10;
    }

    public int rollsConsumed() {
        return pins.size();
    }

    public int score(List<Integer> rolls, int startIndex) {
        int baseScore = pins.get(0);
        if (!isStrike()) {
            baseScore += pins.get(1);
        }

        if (isStrike() || isSpare()) {
            baseScore += rolls.get(startIndex + pins.size());
            if (isStrike()) {
                baseScore += rolls.get(startIndex + pins.size() + 1);
            }
        }
        return baseScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return pins.equals(frame.pins);
    }

    @Override
    public int hashCode() {
        return pins.hashCode();
    }

    @Override
    public String toString() {
        return "Frame{" + "pins=" + pins + "}";
    }
}
