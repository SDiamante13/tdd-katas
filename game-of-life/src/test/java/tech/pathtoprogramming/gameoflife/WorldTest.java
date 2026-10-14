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
