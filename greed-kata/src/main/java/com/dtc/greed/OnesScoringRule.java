package com.dtc.greed;

public class OnesScoringRule implements ScoringRule {
    @Override
    public int calculateScore(Dice dice) {
        int count = dice.howMany(1);
        if (count >= 3) {
            count -= 3;
        }
        return count * 100;
    }
}
