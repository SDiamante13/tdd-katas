package com.dtc.greed;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointCalculationTests {

    private static final String DICE_ROLL_GET_X_POINTS = "Roll of [{0},{1},{2},{3},{4}] gets {5} points";

    @Test
    void noPointsForRollsThatDoNotMeetAnyOfTheScoringRuleRequirements() {
        assertPointCalculation(2, 3, 4, 6, 2, 0);
    }

    @ParameterizedTest(name = DICE_ROLL_GET_X_POINTS)
    @CsvSource({
            "2,3,4,6,5,50",
            "2,3,4,5,6,50",
            "2,3,5,4,6,50",
            "2,5,3,4,6,50",
            "5,2,3,4,6,50"
    })
    void singleFive(int die1, int die2, int die3, int die4, int die5, int expectedPointsValue) {
        assertPointCalculation(die1, die2, die3, die4, die5, expectedPointsValue);
    }

    @ParameterizedTest(name = DICE_ROLL_GET_X_POINTS)
    @CsvSource({
            "2,3,4,5,5,100",
            "2,3,5,5,6,100",
            "2,5,5,2,6,100",
            "5,5,3,2,6,100"
    })
    void doubleFive(int die1, int die2, int die3, int die4, int die5, int expectedPointsValue) {
        assertPointCalculation(die1, die2, die3, die4, die5, expectedPointsValue);
    }

    @ParameterizedTest(name = DICE_ROLL_GET_X_POINTS)
    @CsvSource({
            "2,3,4,6,1,100",
            "2,3,4,1,6,100",
            "2,3,1,4,6,100",
            "2,1,3,4,6,100",
            "1,2,3,4,6,100",
    })
    void singleOne(int die1, int die2, int die3, int die4, int die5, int expectedPointsValue) {
        assertPointCalculation(die1, die2, die3, die4, die5, expectedPointsValue);
    }

    @ParameterizedTest(name = DICE_ROLL_GET_X_POINTS)
    @CsvSource({
            "2,3,4,1,1,200",
            "2,3,5,1,1,250"
    })
    void doubleOne(int die1, int die2, int die3, int die4, int die5, int expectedPointsValue) {
        assertPointCalculation(die1, die2, die3, die4, die5, expectedPointsValue);
    }

    private void assertPointCalculation(int die1, int die2, int die3, int die4, int die5, int expectedPointsValue) {
        Roll roll = new Roll(die1, die2, die3, die4, die5);

        Points actualPoints = roll.calculatePoints();

        assertThat(actualPoints)
                .isEqualTo(new Points(expectedPointsValue));
    }
}
