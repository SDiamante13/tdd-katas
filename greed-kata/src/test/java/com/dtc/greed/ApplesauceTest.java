package com.dtc.greed;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplesauceTest {

    @Test
    void TODO() {
        Assertions.assertThat(new Roll(2,3,4,6,2).calculatePoints())
                .isEqualTo(new Points(0));
    }

    private record Roll(int die1, int die2, int die3, int die4, int die5) {
        public Points calculatePoints() {
            return new Points(1);
        }
    }

    // Game consists of a series of rolls by multiple players
    // This method we are designing only has to do with calculating
    // the best score for a series of die rolls
}
