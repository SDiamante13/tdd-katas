package katacombs;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class GoActionTest {

    private static final Location FOREST = new Location(
            "Forest",
            "You are lost, but determined to get home!",
            new Coordinates(0, 0));
    private static final Location BUILDING = new Location(
            "Building",
            "There's a Brewery",
            new Coordinates(0, 1));
    private static final Location MONSTER = new Location(
            "Monster",
            "There's a goblin in front of you",
            new Coordinates(0, 2));

    @Test
    void playerGoesNorth() {
        World world = new World(new Player(), Locations.create(Set.of(
                FOREST,
                BUILDING,
                MONSTER
        )));

        assertThat(world.respond(Action.GO, "N"))
                .isEqualTo("Building\nThere's a Brewery");
        assertThat(world.respond(Action.GO, "N"))
                .isEqualTo("Monster\nThere's a goblin in front of you");
    }
}
