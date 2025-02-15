package com.dtc.greed;

class FivesScoringRule implements ScoringRule {

    @Override
    public int calculateScore(Dice dice) {
        int count = dice.howMany(5);
        if (count >= 3) {
            count -= 3;
        }
        return count * 50;
    }
}
