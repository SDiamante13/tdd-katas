package com.dtc.greed;

import java.util.Arrays;

record Roll(int die1, int die2, int die3, int die4, int die5) {
    // introduce Dice!
    // ask Dice the questions you have.
    // or ScoringRuleInterface


    public Points calculatePoints() {
        int[] dice = {die1, die2, die3, die4, die5};

        int sum = 0;

        int numberOfFives = (int) Arrays.stream(dice)
                .filter(d -> d == 5)
                .count();
        sum += numberOfFives * 50;

        int numberOfOnes = (int) Arrays.stream(dice)
                .filter(d -> d == 1)
                .count();
        sum += numberOfOnes * 100;

        long count = Arrays.stream(dice)
                .filter(d -> d == 2)
                .count();
        sum += count == 3 ? 200 : 0; // expression

        return new Points(sum);
    }
}
