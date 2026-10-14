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
            boolean livesOn = Rule.satisfies(ALIVE, 1);
            assertThat(livesOn).isFalse();
        }

        @Test
        void withTwoLiveNeighborsLives() {
            boolean livesOn = Rule.satisfies(ALIVE, 2);
            assertThat(livesOn).isTrue();
        }

        @Test
        void withThreeLiveNeighborsLives() {
            boolean livesOn = Rule.satisfies(ALIVE, 3);
            assertThat(livesOn).isTrue();
        }

        @Test
        void withMoreThanThreeLiveNeighborsDies() {
            boolean livesOn = Rule.satisfies(ALIVE, 4);
            assertThat(livesOn).isFalse();
        }
    }

    @Nested
    class AnyDeadCell {
        @Test
        void withExactlyThreeLiveNeighborsLives() {
            boolean livesOn = Rule.satisfies(DEAD, 3);
            assertThat(livesOn).isTrue();
        }
        @Test
        void remainsDeadIfThereAreNotExactlyThreeLiveNeighbors() {
            assertThat(Rule.satisfies(DEAD, 0)).isFalse();
            assertThat(Rule.satisfies(DEAD, 1)).isFalse();
            assertThat(Rule.satisfies(DEAD, 2)).isFalse();
            assertThat(Rule.satisfies(DEAD, 4)).isFalse();
            assertThat(Rule.satisfies(DEAD, 5)).isFalse();
        }
    }
}