package katacombs;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        List<Location> locations = List.of(
                new Location("Entrance", "There's a building north of you", new Coordinates(0, 0)),
                new Location("Building", "There's an entrance south of you", new Coordinates(0, 1)),
                new Location("Building", "There's a monster in front of you", new Coordinates(0, 2))
        );
        Game game = new Game(
                new UserInput(),
                new GameOutput(),
                new World(new Player(new Coordinates(0, 0)),
                        Locations.create(locations))
        );
        game.play();
    }
}
