package katacombs;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static katacombs.LocationTestData.FOREST;
import static katacombs.Locations.create;
import static org.assertj.core.api.Assertions.assertThat;

class LocationsTest {

    @Test
    void findLocationByCoordinates() {
        Locations locations = create(Set.of(
                FOREST.withCoordinates(0, 0))
        );

        assertThat(locations.findLocation(new Coordinates(0, 0)).get())
                .isEqualTo(FOREST);
    }
}