package tech.pathtoprogramming.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTest {

    @Test
    void scoresACompleteGameOfStrikes() {
        BowlingGame game = new BowlingGame();
        rollMany(game, 12, 10);

        assertThat(game.score()).isEqualTo(300);
    }





    private void rollMany(BowlingGame game, int rolls, int pins) {
        for (int roll = 0; roll < rolls; roll++) {
            game.roll(pins);
        }
    }
}
