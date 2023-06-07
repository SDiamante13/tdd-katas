package katacombs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static katacombs.LocationTestData.*;
import static org.assertj.core.api.Assertions.assertThat;

class GoActionTest {

    @Test
    void playerGoesNorth() {
        World world = createWorld(new Coordinates(0, 0),
                FOREST.withCoordinates(0, 0),
                BUILDING.withCoordinates(0, 1),
                MONSTER.withCoordinates(0, 2));

        assertThat(world.respond(Action.GO, "N"))
                .isEqualTo(BUILDING.toString());
        assertThat(world.respond(Action.GO, "N"))
                .isEqualTo(MONSTER.toString());
    }

    @Test
    void playerGoesSouth() {
        World world = createWorld(new Coordinates(0, 2),
                FOREST.withCoordinates(0, 0),
                BUILDING.withCoordinates(0, 1),
                MONSTER.withCoordinates(0, 2));

        assertThat(world.respond(Action.GO, "S"))
                .isEqualTo(BUILDING.toString());
        assertThat(world.respond(Action.GO, "S"))
                .isEqualTo(FOREST.toString());
    }

    @Test
    void playerGoesWest() {
        World world = createWorld(new Coordinates(0, 0),
                FOREST.withCoordinates(0, 0),
                BUILDING.withCoordinates(-1, 0));

        assertThat(world.respond(Action.GO, "W"))
                .isEqualTo(BUILDING.toString());
    }

    @Test
    void playerGoesEast() {
        World world = createWorld(new Coordinates(0, 0),
                FOREST.withCoordinates(0, 0),
                BUILDING.withCoordinates(1, 0));

        assertThat(world.respond(Action.GO, "E"))
                .isEqualTo(BUILDING.toString());
    }

    private World createWorld(Coordinates playerCoordinates, Location... locations) {
        return new World(new Player(playerCoordinates), Locations.create(
                Arrays.stream(locations).collect(Collectors.toSet())
        ));
    }
}
