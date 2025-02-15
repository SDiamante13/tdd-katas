package com.dtc.greed;

import java.util.List;

final class Roll {

    private static final List<ScoringRule> scoringRules = List.of(
            new OnesScoringRule(),
            new FivesScoringRule(),
            new TripletTwosScoringRule()
    );

    private final Dice dice;

    Roll(int die1, int die2, int die3, int die4, int die5) {
        this.dice = new Dice(die1, die2, die3, die4, die5);
    }

    public Points calculatePoints() {
        int sum = scoringRules.stream()
                .mapToInt(a -> a.calculateScore(dice))
                .sum();
        return new Points(sum);
    }
}
