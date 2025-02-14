package com.dtc.greed;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointCalculationTests {

    @Test
    void noPointsForRollsThatDoNotMeetAnyOfTheScoringRuleRequirements() {
        Roll roll = new Roll(2, 3, 4, 6, 2);

        Points actualPoints = roll.calculatePoints();

        assertThat(actualPoints)
                .isEqualTo(new Points(0));
    }

    @Test
    void name() {
        Roll roll = new Roll(2, 3, 4, 6, 5);

        Points actualPoints = roll.calculatePoints();

        assertThat(actualPoints)
                .isEqualTo(new Points(50));
    }
}
