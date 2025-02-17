package com.dtc.greed;

import java.util.Arrays;

public class Dice {

    public final int[] values;

    public Dice(int... dieValues) {
        this.values = dieValues;
    }

    int howMany(int x) {
        return (int) Arrays.stream(values)
                .filter(d -> d == x)
                .count();
    }
}
