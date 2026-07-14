package tech.pathtoprogramming.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTest {

    @Test
    void scoresAGutterGame() {
        BowlingGame game = new BowlingGame();
        rollMany(game, 20, 0);

        assertThat(game.score()).isEqualTo(0);
    }

    private void rollMany(BowlingGame game, int rolls, int pins) {
        for (int roll = 0; roll < rolls; roll++) {
            game.roll(pins);
        }
    }
}
