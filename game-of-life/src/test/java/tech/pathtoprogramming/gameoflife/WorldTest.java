package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.Set;

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
        );
        assertThat(block.next()).isEqualTo(block);
    }

    @Test
    void blinkerPatternFlips() {
        World blinker = parse("""
                . . .
                # # #
                . . .
                """
        );
        assertThat(blinker.next()).isEqualTo(
                parse("""
                . # .
                . # .
                . # .
                """
                )
        );
    }
}
