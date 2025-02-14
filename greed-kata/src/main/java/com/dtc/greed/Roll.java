package com.dtc.greed;

import java.util.Arrays;

class Dice {

    public final int[] dice;

    public Dice(int die1, int die2, int die3, int die4, int die5) {
        this.dice = new int[] {die1, die2, die3, die4, die5};
    }

    int howMany(int x) {
        return (int) Arrays.stream(dice)
                .filter(d -> d == x)
                .count();
    }
}
record Roll(int die1, int die2, int die3, int die4, int die5) {
    // introduce Dice!
    // ask Dice the questions you have.
    // or ScoringRuleInterface


    public Points calculatePoints() {

        Dice dice = new Dice(die1, die2, die3, die4, die5);

        int sum = dice.howMany(5) * 50 +
                dice.howMany(1) * 100 +
                (dice.howMany(2) == 3 ? 200 : 0);

        return new Points(sum);
    }

}
