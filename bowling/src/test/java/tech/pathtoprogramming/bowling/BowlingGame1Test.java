package tech.pathtoprogramming.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGame1Test {

    private BowlingGame1 bowlingGame;

    @BeforeEach
    void setUp() {
        bowlingGame = new BowlingGame1();
    }

    @Test
    void instantiateScoreOfZero() {
        int result = bowlingGame.score();

        assertThat(result).isZero();
    }

    @Test
    void rollForOnePin() {
        rollPins(1);

        int result = bowlingGame.score();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void rollSpare() {
        rollPins(4, 6, 1, 0);

        int result = bowlingGame.score();

        assertThat(result).isEqualTo(12);
    }

    @Test
    void rollTwoSpares() {
        rollPins(8, 2, 9, 1, 3, 3);

        int result = bowlingGame.score();

        assertThat(result).isEqualTo(38);
    }

    @Test
    void rollStrike() {
        rollPins(10, 3, 3);

        int result = bowlingGame.score();

        assertThat(result).isEqualTo(22);
    }

    private void rollPins(int... rollScores) {
        for (int rollScore : rollScores) {
            bowlingGame.roll(rollScore);
        }
    }
}
