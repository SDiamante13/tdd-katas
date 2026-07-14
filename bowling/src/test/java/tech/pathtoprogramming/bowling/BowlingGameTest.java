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

    @Test
    void scoresAnOpenFrame() {
        BowlingGame game = new BowlingGame();
        game.roll(3);
        game.roll(4);
        rollMany(game, 18, 0);

        assertThat(game.score()).isEqualTo(7);
    }

    @Test
    void scoresASpare() {
        BowlingGame game = new BowlingGame();
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(game, 17, 0);

        assertThat(game.score()).isEqualTo(16);
    }

    @Test
    void scoresAStrike() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollMany(game, 16, 0);

        assertThat(game.score()).isEqualTo(24);
    }

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
