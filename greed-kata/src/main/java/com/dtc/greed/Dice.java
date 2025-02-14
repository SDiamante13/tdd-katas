package com.dtc.greed;

import java.util.Arrays;

public class Dice {

    public final int[] dice;

    public Dice(int die1, int die2, int die3, int die4, int die5) {
        this.dice = new int[]{die1, die2, die3, die4, die5};
    }

    int howMany(int x) {
        return (int) Arrays.stream(dice)
                .filter(d -> d == x)
                .count();
    }
}
