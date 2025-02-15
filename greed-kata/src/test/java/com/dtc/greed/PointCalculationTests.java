package com.dtc.greed;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointCalculationTests {

    private static final String DICE_ROLL_GET_X_POINTS = "Roll of [{0},{1},{2},{3},{4}] gets {5} points";

    @Test
    void noPointsForRollsThatDoNotMeetAnyOfTheScoringRuleRequirements() {
        assertThat(pointsFor(2, 3, 4, 6, 2))
                .isEqualTo(new Points(0));
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
        assertThat(pointsFor(die1, die2, die3, die4, die5))
                .isEqualTo(new Points(expectedPointsValue));
    }

    @ParameterizedTest(name = DICE_ROLL_GET_X_POINTS)
    @CsvSource({
            "2,3,4,5,5,100",
            "2,3,5,5,6,100",
            "2,5,5,2,6,100",
            "5,5,3,2,6,100"
    })
    void doubleFive(int die1, int die2, int die3, int die4, int die5, int expectedPointsValue) {
        assertThat(pointsFor(die1, die2, die3, die4, die5))
                .isEqualTo(new Points(expectedPointsValue));
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
        assertThat(pointsFor(die1, die2, die3, die4, die5))
                .isEqualTo(new Points(expectedPointsValue));
    }

    @ParameterizedTest(name = DICE_ROLL_GET_X_POINTS)
    @CsvSource({
            "2,3,4,1,1,200",
            "2,3,5,1,1,250"
    })
    void doubleOne(int die1, int die2, int die3, int die4, int die5, int expectedPointsValue) {
        assertThat(pointsFor(die1, die2, die3, die4, die5))
                .isEqualTo(new Points(expectedPointsValue));
    }

    @ParameterizedTest(name = DICE_ROLL_GET_X_POINTS)
    @CsvSource({
            "1,1,1,6,3,1000",
            "1,1,1,1,3,1100",
            "1,1,1,1,1,1200",
            "2,2,2,6,3,200",
            "3,3,3,6,2,300",
            "4,4,4,6,2,400",
            "5,5,5,6,2,500",
            "5,5,5,5,2,550",
            "5,5,5,5,5,600",
            "6,6,6,2,2,600",
    })
    void triples(int die1, int die2, int die3, int die4, int die5, int expectedPointsValue) {
        assertThat(pointsFor(die1, die2, die3, die4, die5))
                .isEqualTo(new Points(expectedPointsValue));
    }

    @ParameterizedTest(name = DICE_ROLL_GET_X_POINTS)
    @CsvSource({
            "1,1,1,5,1,1150",
            "3,4,5,3,3,350",
            "1,5,1,2,4,250",
    })
    void examples(int die1, int die2, int die3, int die4, int die5, int expectedPointsValue) {
        assertThat(pointsFor(die1, die2, die3, die4, die5))
                .isEqualTo(new Points(expectedPointsValue));
    }

    private Points pointsFor(int die1, int die2, int die3, int die4, int die5) {
        return new Roll(new Dice(die1, die2, die3, die4, die5))
                .calculatePoints();
    }
}
