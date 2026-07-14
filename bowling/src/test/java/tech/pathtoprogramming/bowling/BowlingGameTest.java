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
    @Test
    void anOpenFrameScoresThePinsKnockedDown() {
        BowlingGame game = new BowlingGame();

        game.roll(3);
        game.roll(4);
        rollZeros(game, 18);

        assertThat(game.score()).isEqualTo(7);
    }

    private void rollZeros(BowlingGame game, int rolls) {
        for (int roll = 0; roll < rolls; roll++) {
            game.roll(0);
        }
    }
