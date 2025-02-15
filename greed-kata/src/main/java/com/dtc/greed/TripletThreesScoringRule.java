package com.dtc.greed;

public class TripletThreesScoringRule implements ScoringRule {
    @Override
    public int calculateScore(Dice dice) {
        return dice.howMany(3) == 3 ? 300 : 0;
    }
}
