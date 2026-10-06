package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class WorldTest {

    @Test
    void worldOfDeadCellsYieldsOnlyDeadCells() {
        assertThat(World.empty().next()).isEqualTo(World.empty());
    }

    @Test
    void blockPatternStaysTheSameTheNextGeneration() {
        World block = parse("""
                . . . .
                . # # .
                . # # .
                . . . .
                """
        );
        assertThat(block.next()).isEqualTo(block);
    }

    private World parse(String input) {
        return new World(Set.of(new Position(1,1), new Position(2,1), new Position(1,2), new Position(2,2)));
    }
}

record Position(int x, int y) {

}
