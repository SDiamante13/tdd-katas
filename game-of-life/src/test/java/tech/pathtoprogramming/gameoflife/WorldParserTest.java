package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.gameoflife.WorldParser.parse;

class WorldParserTest {

    @Test
    void parseSingleRow() {
        World world = parse("""
                . #
                """
        );
        assertThat(world).isEqualTo(new World(Set.of(new Position(1, 0))));
    }

    @Test
    void parseTwoLiveCells() {
        World world = parse("""
                # . #
                """
        );
        assertThat(world).isEqualTo(new World(Set.of(new Position(0, 0), new Position(2, 0))));
    }

    @Test
    void parseTwoRowsLiveCells() {
        World world = parse("""
                # .
                . #
                """
        );
        assertThat(world).isEqualTo(new World(Set.of(
                new Position(0, 0), new Position(1, 1)
        )));
    }
}
