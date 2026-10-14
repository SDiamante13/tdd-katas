package tech.pathtoprogramming.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    void aPositionAtHasEightNeighborsOneOne() {
        Position position = new Position(1, 1);
        assertThat(position.neighbors()).isEqualTo(
                Set.of(
                        new Position(0,0),
                        new Position(1, 0),
                        new Position(2, 0),
                        new Position(2, 1),
                        new Position(2, 2),
                        new Position(1, 2),
                        new Position(0, 2),
                        new Position(0, 1))
        );
        position = new Position(2, 1);
        assertThat(position.neighbors()).isEqualTo(
                Set.of(
                        new Position(1,0),
                        new Position(2, 0),
                        new Position(3, 0),
                        new Position(3, 1),
                        new Position(3, 2),
                        new Position(2, 2),
                        new Position(1, 2),
                        new Position(1, 1))
        );
        position = new Position(1, 2);
        assertThat(position.neighbors()).isEqualTo(
                Set.of(
                        new Position(0,1),
                        new Position(1, 1),
                        new Position(2, 1),
                        new Position(2, 2),
                        new Position(2, 3),
                        new Position(1, 3),
                        new Position(0, 3),
                        new Position(0, 2))
        );
        position = new Position(2, 2);
        assertThat(position.neighbors()).isEqualTo(
                Set.of(
                        new Position(1,0),
                        new Position(2, 0),
                        new Position(3, 0),
                        new Position(3, 1),
                        new Position(3, 2),
                        new Position(2, 2),
                        new Position(1, 2),
                        new Position(1, 1))
        );
    }



    @Test
    @Disabled
    void aPositionAtOriginHasThreeNeighborPositions() {
        Position position = new Position(0, 0);
        assertThat(position.neighbors()).isEqualTo(
                Set.of(new Position(1, 0),
                        new Position(0, 1),
                        new Position(1, 1))
        );

    }

    @Test
    @Disabled
    void aPositionHasUpToEightUniqueNeighborPositions() {

    }
}