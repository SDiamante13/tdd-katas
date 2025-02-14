package com.dtc.greed;

class FivesScoringRule implements ScoringRule {
    @Override
    public int calculateScore(Dice dice) {
        return dice.howMany(5) * 50;
    }
}
