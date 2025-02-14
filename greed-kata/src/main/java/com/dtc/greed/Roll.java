package com.dtc.greed;

import java.util.List;

record Roll(int die1, int die2, int die3, int die4, int die5) {

    private static final List<ScoringRule> scoringRules = List.of(new FivesScoringRule());

    public Points calculatePoints() {

        Dice dice = new Dice(die1, die2, die3, die4, die5);

        int i = scoringRules.get(0).calculateScore(dice);

        int sum = i +
                dice.howMany(1) * 100 +
                (dice.howMany(2) == 3 ? 200 : 0);

        return new Points(sum);
    }

}
