package katacombs;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TestHelpers {

    public static World createWorld(Coordinates playerCoordinates, Location... locations) {
        return new World(new Player(playerCoordinates), Locations.create(
                Arrays.stream(locations).collect(Collectors.toSet())
        ));
    }
}
