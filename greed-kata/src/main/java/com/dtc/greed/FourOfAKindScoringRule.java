package com.dtc.greed;

public class FourOfAKindScoringRule implements ScoringRule {

    private final int dieValue;
    private final int score;

    public FourOfAKindScoringRule(int dieValue, int score) {
        this.dieValue = dieValue;
        this.score = score;
    }

    @Override
    public int calculateScore(Dice dice) {
        return dice.howMany(dieValue) == 4 ? score : 0;
    }
}
