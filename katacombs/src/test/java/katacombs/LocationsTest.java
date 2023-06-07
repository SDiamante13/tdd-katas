package katacombs;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static katacombs.Locations.create;
import static org.assertj.core.api.Assertions.assertThat;

class LocationsTest {

    private static final Location FOREST = new Location(
            "Forest",
            "You are lost, but determined to get home!",
            new Coordinates(0, 0));

    @Test
    void findLocationByCoordinates() {
        Locations locations = create(Set.of(FOREST));

        assertThat(locations.findLocation(new Coordinates(0, 0)))
                .isEqualTo(FOREST);
    }
}