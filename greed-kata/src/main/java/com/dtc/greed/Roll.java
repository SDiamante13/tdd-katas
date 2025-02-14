package com.dtc.greed;

record Roll(int die1, int die2, int die3, int die4, int die5) {
    public Points calculatePoints() {
        int[] dice = {die1, die2, die3, die4, die5};

        if (dice[0] == 5 || dice[1] == 5 || dice[2] == 5 || dice[3] == 5 || dice[4] == 5) {
            return new Points(50);
        }
        return new Points(0);
    }
}
