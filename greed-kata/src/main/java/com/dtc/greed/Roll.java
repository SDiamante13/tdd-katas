package com.dtc.greed;

record Roll(int die1, int die2, int die3, int die4, int die5) {
    public Points calculatePoints() {
        return new Points(0);
    }
}
