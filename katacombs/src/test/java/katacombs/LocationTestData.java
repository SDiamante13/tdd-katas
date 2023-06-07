package katacombs;

public class LocationTestData {

    public static final Location FOREST = new Location(
            "Forest",
            "You are lost, but determined to get home!",
            new Coordinates(0, 0));
    public static final Location BUILDING = new Location(
            "Building",
            "There's a Brewery",
            new Coordinates(0, 1));
    public static final Location MONSTER = new Location(
            "Monster",
            "There's a goblin in front of you",
            new Coordinates(0, 2));
    public static final Location CAVE = new Location(
            "Cave",
            "You've entered a dark cave",
            new Coordinates(0, 3));
}
