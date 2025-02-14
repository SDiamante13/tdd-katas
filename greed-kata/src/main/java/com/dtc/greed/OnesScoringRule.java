package com.dtc.greed;

public class OnesScoringRule implements ScoringRule {
    @Override
    public int calculateScore(Dice dice) {
        return dice.howMany(1) * 100;
    }
}
