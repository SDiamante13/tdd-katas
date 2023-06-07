package katacombs;

import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

class Locations {

    private final Map<Coordinates, Location> map;

    public Locations(Set<Location> locationSet) {
        map = locationSet.stream()
                .collect(toMap(Location::coordinates, loc -> loc));
    }

    static Locations create(Set<Location> locationSet) {
        return new Locations(locationSet);
    }

    public Location findLocation(Coordinates coordinates) {
        return map.get(coordinates);
    }
}
