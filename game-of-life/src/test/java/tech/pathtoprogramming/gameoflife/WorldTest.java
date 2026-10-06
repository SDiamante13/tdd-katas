package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WorldTest {

    @Test
    void worldOfDeadCellsYieldsOnlyDeadCells() {
        assertThat(World.empty().next()).isEqualTo(World.empty());
    }
}
