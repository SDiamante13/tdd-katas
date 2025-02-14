package com.dtc.greed;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointCalculationTests {

    @Test
    void noPointsForRollsThatDoNotMeetAnyOfTheScoringRuleRequirements() {
        Roll roll = new Roll(2, 3, 4, 6, 2);

        Points actualPoints = roll.calculatePoints();

        assertThat(actualPoints)
                .isEqualTo(new Points(0));
    }

    @ParameterizedTest(name="Roll of [{0},{1},{2},{3},{4}] gets {5} points")
    @CsvSource({
            "2,3,4,6,5,50",
            "2,3,4,5,6,50",
            "2,3,5,4,6,50",
            "2,5,3,4,6,50",
            "5,2,3,4,6,50"
    })
    void singleFive(int die1, int die2, int die3, int die4, int die5, int expectedPointsValue) {
        Roll roll = new Roll(die1, die2, die3, die4, die5);

        Points actualPoints = roll.calculatePoints();

        assertThat(actualPoints)
                .isEqualTo(new Points(expectedPointsValue));
    }

    @ParameterizedTest(name="Roll of [{0},{1},{2},{3},{4}] gets {5} points")
    @CsvSource({
            "2,3,4,5,5,100"
    })
    void doubleFive(int die1, int die2, int die3, int die4, int die5, int expectedPointsValue) {
        Roll roll = new Roll(die1, die2, die3, die4, die5);

        Points actualPoints = roll.calculatePoints();

        assertThat(actualPoints)
                .isEqualTo(new Points(expectedPointsValue));
    }
}
