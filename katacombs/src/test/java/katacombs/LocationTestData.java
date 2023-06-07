package katacombs;

public class LocationTestData {

    public static final Location FOREST = new Location(
            "Forest",
            "You are lost, but determined to get home!",
            "There are trees ahead.", new Coordinates(0, 0));
    public static final Location BUILDING = new Location(
            "Building",
            "There's a Brewery",
            "The sign says Free Beer On Tuesdays", new Coordinates(0, 1));
    public static final Location MONSTER = new Location(
            "Monster",
            "There's a goblin in front of you",
            "You see a green figure up ahead", new Coordinates(0, 2));
    public static final Location CAVE = new Location(
            "Cave",
            "You've entered a dark cave",
            "An entrance to a cave is up ahead", new Coordinates(0, 3));
}
