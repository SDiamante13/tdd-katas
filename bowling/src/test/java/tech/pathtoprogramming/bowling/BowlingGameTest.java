package tech.pathtoprogramming.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTest {

    @Test
    void scoresAnOpenFrame() {
        BowlingGame game = new BowlingGame();
        game.roll(3);
        game.roll(4);
        rollMany(game, 18, 0);

        assertThat(game.score()).isEqualTo(7);
    }


    private void rollMany(BowlingGame game, int rolls, int pins) {
        for (int roll = 0; roll < rolls; roll++) {
            game.roll(pins);
        }
    }
}
