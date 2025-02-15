package com.dtc.greed;

public class TripleScoringRule implements ScoringRule {

    private final int dieValue;
    private final int tripleScoreValue;

    public TripleScoringRule(int dieValue, int tripleScoreValue) {
        this.dieValue = dieValue;
        this.tripleScoreValue = tripleScoreValue;
    }

    @Override
    public int calculateScore(Dice dice) {
        return dice.howMany(dieValue) >= 3 ? tripleScoreValue : 0;
    }
}
