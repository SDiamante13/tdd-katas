package tech.pathtoprogramming.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    @Disabled
    void aPositionAtOriginHasThreeNeighborPositions() {
        Position position = new Position(0, 0);
        Assertions.assertThat(position.neighbors()).isEqualTo(
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