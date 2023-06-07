package katacombs;

import java.util.Set;

public class MainApplication {
    public static void main(String[] args) {
        Coordinates playerCoordinates = new Coordinates(0, 0);
        Locations locations = Locations.create(
                Set.of(new Location(
                                "Forest",
                                "You are lost, but determined to get home!",
                                "There are trees ahead.",
                                new Coordinates(0, 0)),
                        new Location(
                                "Building",
                                "There's a Brewery",
                                "The sign says Free Beer On Tuesdays",
                                new Coordinates(0, 1)),
                        new Location(
                                "Monster",
                                "There's a goblin in front of you",
                                "You see a green figure up ahead",
                                new Coordinates(0, 2)),
                        new Location(
                                "Cave",
                                "You've entered a dark cave",
                                "An entrance to a cave is up ahead",
                                new Coordinates(0, 3))));
        World world = new World(new Player(playerCoordinates), locations);
        Game game = new Game(world);

        game.play();
    }

}
