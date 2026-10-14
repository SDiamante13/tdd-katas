package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.gameoflife.State.*;

class StateTest {

    @Nested
    class AnyLiveCell {
        @Test
        void withFewerThanTwoLiveNeighborsDies() {
            State nextState = ALIVE.next(1);
            assertThat(nextState).isEqualTo(DEAD);
        }

        @Test
        void withTwoLiveNeighborsLives() {
            State nextState = ALIVE.next(2);
            assertThat(nextState).isEqualTo(ALIVE);
        }

        @Test
        void withThreeLiveNeighborsLives() {
            State nextState = ALIVE.next(3);
            assertThat(nextState).isEqualTo(ALIVE);
        }

        @Test
        void withMoreThanThreeLiveNeighborsDies() {
            State nextState = ALIVE.next(4);
            assertThat(nextState).isEqualTo(DEAD);
        }
    }

    @Nested
    class AnyDeadCell {
        @Test
        void withExactlyThreeLiveNeighborsLives() {
            State nextState = DEAD.next(3);
            assertThat(nextState).isEqualTo(ALIVE);
        }
        @Test
        void remainsDeadIfThereAreNotExactlyThreeLiveNeighbors() {
            assertThat(DEAD.next(0)).isEqualTo(DEAD);
            assertThat(DEAD.next(1)).isEqualTo(DEAD);
            assertThat(DEAD.next(2)).isEqualTo(DEAD);
            assertThat(DEAD.next(4)).isEqualTo(DEAD);
            assertThat(DEAD.next(5)).isEqualTo(DEAD);
        }
    }
}