package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RuleTest {

    @Nested
    class AnyLiveCell {
        @Test
        void withFewerThanTwoLiveNeighborsDies() {
            boolean livesOn = Rule.satisfies(true, 1);
            assertThat(livesOn).isFalse();
        }

        @Test
        void withTwoLiveNeighborsLives() {
            boolean livesOn = Rule.satisfies(true, 2);
            assertThat(livesOn).isTrue();
        }

        @Test
        void withThreeLiveNeighborsLives() {
            boolean livesOn = Rule.satisfies(true, 3);
            assertThat(livesOn).isTrue();
        }

        @Test
        void withMoreThanThreeLiveNeighborsDies() {
            boolean livesOn = Rule.satisfies(true, 4);
            assertThat(livesOn).isFalse();
        }
    }

    @Nested
    class AnyDeadCell {
        @Test
        void withExactlyThreeLiveNeighborsLives() {
            boolean livesOn = Rule.satisfies(false, 3);
            assertThat(livesOn).isTrue();
        }
        @Test
        void remainsDeadIfThereAreNotExactlyThreeLiveNeighbors() {
            assertThat(Rule.satisfies(false, 0)).isFalse();
            assertThat(Rule.satisfies(false, 1)).isFalse();
            assertThat(Rule.satisfies(false, 2)).isFalse();
            assertThat(Rule.satisfies(false, 4)).isFalse();
            assertThat(Rule.satisfies(false, 5)).isFalse();
        }
    }
}