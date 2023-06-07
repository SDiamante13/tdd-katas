package katacombs;

import org.junit.jupiter.api.Test;

import static katacombs.LocationTestData.*;
import static katacombs.TestHelpers.createWorld;
import static org.assertj.core.api.Assertions.assertThat;

class LookUseCaseTest {

    @Test
    void canLookInAllDirections() {
        World world = createWorld(new Coordinates(0, 0),
                FOREST.withCoordinates(0, 0),
                BUILDING.withCoordinates(0, 1),
                MONSTER.withCoordinates(-1, 0),
                CAVE.withCoordinates(1, 0));

        assertThat(world.respond(Action.LOOK, "N"))
                .isEqualTo(BUILDING.lookDescription());
        assertThat(world.respond(Action.LOOK, "E"))
                .isEqualTo(CAVE.lookDescription());
        assertThat(world.respond(Action.LOOK, "W"))
                .isEqualTo(MONSTER.lookDescription());
        assertThat(world.respond(Action.LOOK, "S"))
                .isEqualTo("Nothing interesting to look at there!");
    }
}
