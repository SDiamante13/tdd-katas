package tech.pathtoprogramming.bowling;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

// [x] - gutter balls
// [x] - all ones
// [ ] - all 9's
// [ ] - mostly ones with spare at start
// [ ] - mostly ones with strike at start
// [ ] - perfect game?
class BowlingGameTest {

    private final BowlingGame game = new BowlingGame();

    @Test
    void allZeroes() {
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertThat(game.score()).isZero();
    }

    @Test
    void allOnes() {
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertThat(game.score()).isEqualTo(20);
    }
}
