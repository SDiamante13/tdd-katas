package com.dtc.greed;

import java.util.stream.IntStream;

record Roll(int die1, int die2, int die3, int die4, int die5) {
    public Points calculatePoints() {
        IntStream diceStream = IntStream.of(die1, die2, die3, die4, die5);
        if (diceStream.anyMatch(value -> value == 5)) {
            return new Points(50);
        }
        return new Points(0);
    }
}
