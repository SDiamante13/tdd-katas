package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.gameoflife.State.*;

class RuleTest {

    @Nested
    class AnyLiveCell {
        @Test
        void withFewerThanTwoLiveNeighborsDies() {
            boolean livesOn = next(ALIVE, 1);
            assertThat(livesOn).isFalse();
        }

        @Test
        void withTwoLiveNeighborsLives() {
            boolean livesOn = next(ALIVE, 2);
            assertThat(livesOn).isTrue();
        }

        @Test
        void withThreeLiveNeighborsLives() {
            boolean livesOn = next(ALIVE, 3);
            assertThat(livesOn).isTrue();
        }

        @Test
        void withMoreThanThreeLiveNeighborsDies() {
            boolean livesOn = next(ALIVE, 4);
            assertThat(livesOn).isFalse();
        }
    }

    @Nested
    class AnyDeadCell {
        @Test
        void withExactlyThreeLiveNeighborsLives() {
            boolean livesOn = next(DEAD, 3);
            assertThat(livesOn).isTrue();
        }
        @Test
        void remainsDeadIfThereAreNotExactlyThreeLiveNeighbors() {
            assertThat(next(DEAD, 0)).isFalse();
            assertThat(next(DEAD, 1)).isFalse();
            assertThat(next(DEAD, 2)).isFalse();
            assertThat(next(DEAD, 4)).isFalse();
            assertThat(next(DEAD, 5)).isFalse();
        }
    }
}