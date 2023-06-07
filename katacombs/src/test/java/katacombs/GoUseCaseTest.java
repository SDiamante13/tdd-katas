package katacombs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static katacombs.LocationTestData.*;
import static org.assertj.core.api.Assertions.assertThat;

class GoUseCaseTest {

    @Test
    void playerCanMoveToDifferentLocations() {
        World world = createWorld(new Coordinates(0, 0),
                FOREST.withCoordinates(0, 0),
                BUILDING.withCoordinates(0, 1),
                MONSTER.withCoordinates(-1, 0),
                CAVE.withCoordinates(1, 0));

        assertThat(world.respond(Action.GO, "N"))
                .isEqualTo(BUILDING.toString());
        assertThat(world.respond(Action.GO, "S"))
                .isEqualTo(FOREST.toString());
        assertThat(world.respond(Action.GO, "W"))
                .isEqualTo(MONSTER.toString());
        assertThat(world.respond(Action.GO, "E"))
                .isEqualTo(FOREST.toString());
        assertThat(world.respond(Action.GO, "E"))
                .isEqualTo(CAVE.toString());
        assertThat(world.respond(Action.GO, "S"))
                .isEqualTo("You can't move there!");
    }

    private World createWorld(Coordinates playerCoordinates, Location... locations) {
        return new World(new Player(playerCoordinates), Locations.create(
                Arrays.stream(locations).collect(Collectors.toSet())
        ));
    }
}
