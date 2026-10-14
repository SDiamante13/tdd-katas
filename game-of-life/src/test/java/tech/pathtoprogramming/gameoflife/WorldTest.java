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

    @Test
    void blinkerPatternFlips() {
        // live are 0,1 - 1,1 - 2,1
        World blinker = parse("""
                . . .
                # # #
                . . .
                """
        ).next();
        assertThat(blinker.next()).isEqualTo(
                parse("""
                . # .
                . # .
                . # .
                """
                )
        );
    }

    @Test
    void countOfLiveNeighbors_noMatchesReturnsZero() {
        Set<Position> positionOfLiveNeighbors = Set.of(new Position(0,0), new Position(1,0));
        Set<Position> possibleNeighbors = Set.of(
                new Position(1,0),
                new Position(2, 0),
                new Position(3, 0),
                new Position(3, 1),
                new Position(3, 2),
                new Position(2, 2),
                new Position(1, 2),
                new Position(1, 1));
        int countOfLiveNeighbors = World.countOfLiveNeighbors(positionOfLiveNeighbors, possibleNeighbors);
        assertThat(countOfLiveNeighbors).isEqualTo(1);
    }
}
