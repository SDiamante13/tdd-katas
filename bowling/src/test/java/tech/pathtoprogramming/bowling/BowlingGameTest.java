package tech.pathtoprogramming.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// [x] - gutter balls
// [x] - all ones
// [x] - all 4's
// [ ] - mostly ones with spare at start
// [ ] - mostly ones with strike at start
// [ ] - perfect game?
class BowlingGameTest {

    private final BowlingGame game = new BowlingGame();

    @Test
    void allZeroes() {
        rollMultiple(0, 20);
        assertThat(game.score()).isZero();
    }

    @Test
    void allOnes() {
        rollMultiple(1, 20);
        assertThat(game.score()).isEqualTo(20);
    }

    @Test
    void allFours() {
        rollMultiple(4, 20);
        assertThat(game.score()).isEqualTo(80);
    }

    @Test
    void spare() {
        game.roll(9);
        game.roll(1);
        rollMultiple(1, 18);
        assertThat(game.score()).isEqualTo(29);
    }

    private void rollMultiple(int pins, int times) {
        for (int i = 0; i < times; i++) {
            game.roll(pins);
        }
    }
}
