package katacombs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WorldTest {

    private static final Location FOREST = new Location("Forest", "You are lost, but determined to get home!", Coordinates.ORIGIN);
    private static final Location BUILDING = new Location("Building", "There's a Brewery", new Coordinates(0, 1));
    private static final Location MONSTER = new Location("Monster", "There's a goblin in front of you. What do you want to do?", new Coordinates(0, 2));

    @Test
    void goNorth() {
        World world = new World(
                new Player(new Coordinates(0, 0)),
                Locations.create(List.of(FOREST, BUILDING, MONSTER))
        );

        world.executeAction("GO N");

        assertThat(world.currentLocation()).isEqualTo(BUILDING);
    }

    @Test
    void throwsIllegalArgumentExceptionWhenUnknownCommandIsProvided() {
        World world = new World(
                new Player(new Coordinates(0, 0)),
                Locations.create(List.of(FOREST, BUILDING, MONSTER))
        );

        assertThrows(IllegalArgumentException.class, () ->
                world.executeAction("NA"));
    }
}