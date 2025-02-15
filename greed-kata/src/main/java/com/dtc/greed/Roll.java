package com.dtc.greed;

import java.util.List;

record Roll(Dice dice) {

    private static final List<ScoringRule> scoringRules = List.of(
            new OnesScoringRule(),
            new FivesScoringRule(),
            new TripleScoringRule(2, 200),
            new TripleScoringRule(3, 300)
    );

    public Points calculatePoints() {
        int sum = scoringRules.stream()
                .mapToInt(scoringRule -> scoringRule.calculateScore(dice))
                .sum();
        return new Points(sum);
    }
}
