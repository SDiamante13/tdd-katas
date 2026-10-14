package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.gameoflife.WorldParser.parse;

class WorldTest {

    @Test
    void worldOfDeadCellsYieldsOnlyDeadCells() {
        assertThat(World.empty().next()).isEqualTo(World.empty());
    }

    @Test
    void blockPatternStaysTheSameTheNextGeneration() {
        // live are 1,1 - 2,1 - 1,2 - 2,2
        World block = parse("""
                . . . .
                . # # .
                . # # .
                . . . .
                """
        ).next();
        assertThat(block.next()).isEqualTo(block);
    }
}
