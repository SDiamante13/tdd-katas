package com.dtc.greed;

import java.util.List;

record Roll(int die1, int die2, int die3, int die4, int die5) {

    private static final List<ScoringRule> scoringRules = List.of(new FivesScoringRule(), new OnesScoringRule(), new TripletTwosScoringRule());

    public Points calculatePoints() {
        Dice dice = new Dice(die1, die2, die3, die4, die5);

        int sum = scoringRules.stream()
                .mapToInt(a -> a.calculateScore(dice))
                .sum();

        return new Points(sum);
    }

}
