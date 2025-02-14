package com.dtc.greed;

record Roll(int die1, int die2, int die3, int die4, int die5) {
    public Points calculatePoints() {
        if (die5 == 5) {
            return new Points(50);
        }
        return new Points(0);
    }
}
