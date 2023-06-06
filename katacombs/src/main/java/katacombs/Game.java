package katacombs;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.toMap;

class Locations {

    private final Map<Coordinates, Location> map;

    private Locations(List<Location> locations) {
        map = locations.stream()
                .collect(toMap(
                        Location::coordinates,
                        loc -> loc)
                );
    }

    public static Locations create(List<Location> locations) {
        return new Locations(locations);
    }

    public Location findLocation(Coordinates coordinates) {
        // what to do if there is no location there?
        return map.get(coordinates);
    }
}

public class Game {

    private final UserInput userInput;
    private final GameOutput gameOutput;
    private final World world;

    public Game(UserInput userInput, GameOutput gameOutput, World world) {
        this.userInput = userInput;
        this.gameOutput = gameOutput;
        this.world = world;
    }

    public void play() {
        do {
            var currentLocation = world.currentLocation();
            gameOutput.print(currentLocation.toString());
            String input = userInput.capture();
            world.executeAction(input);
        } while (true);
    }
}

class Player {

    private Coordinates currentCoordinates;

    Player(Coordinates currentCoordinates) {
        this.currentCoordinates = currentCoordinates;
    }

    public Coordinates currentCoordinates() {
        return currentCoordinates;
    }

    public void move(Direction direction) {
        switch (direction) {
            case N:
                currentCoordinates = currentCoordinates.moveNorth();
                break;
        }
    }
}

enum Direction {
    N,
    E,
    S,
    W
}

class Location {

    private final String title; // primitive obsession (data clump)
    private final String mainDescription; // primitive Obsession (data clump)

    private final Coordinates coordinates;

    Location(String title, String mainDescription, Coordinates coordinates) {
        this.title = title;
        this.mainDescription = mainDescription;
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return title + "\n" + mainDescription;
    }

    public Coordinates coordinates() {
        return coordinates;
    }
}

class Coordinates {

    public static final Coordinates ORIGIN = new Coordinates(0,0);

    private final int x;
    private final int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates moveNorth() {
        return new Coordinates(x, y + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

class UserInput {
    String capture() {
        return new Scanner(System.in).nextLine();
    }

}

class GameOutput {
    void print(String words) {
        System.out.println(words);
    }
}
