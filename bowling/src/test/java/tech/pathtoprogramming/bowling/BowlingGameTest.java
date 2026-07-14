package tech.pathtoprogramming.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTest {

    @Test
    void aGutterGameScoresZero() {
        BowlingGame game = new BowlingGame();

        for (int roll = 0; roll < 20; roll++) {
            game.roll(0);
        }

        assertThat(game.score()).isZero();
    }
}
