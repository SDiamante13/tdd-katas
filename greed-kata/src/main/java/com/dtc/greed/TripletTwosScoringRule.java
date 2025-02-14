package com.dtc.greed;

public class TripletTwosScoringRule implements ScoringRule {
    @Override
    public int calculateScore(Dice dice) {
        return dice.howMany(2) == 3 ? 200 : 0;
    }
}
