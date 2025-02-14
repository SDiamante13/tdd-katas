package com.dtc.greed;

import java.util.Arrays;

record Roll(int die1, int die2, int die3, int die4, int die5) {
    public Points calculatePoints() {
        int[] dice = {die1, die2, die3, die4, die5};
        int sum = Arrays.stream(dice)
                .filter(d -> d == 5)
                .map(d -> 50)
                .sum();
        sum += Arrays.stream(dice)
                .filter(d -> d == 1)
                .map(d -> 100)
                .sum();
        long count = Arrays.stream(dice)
                .filter(d -> d == 2)
                .count();
        sum += count == 3 ? 200 : 0;

        return new Points(sum);
    }
}
