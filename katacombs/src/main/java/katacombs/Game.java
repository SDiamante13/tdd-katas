package katacombs;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.toMap;

class LocationMap {

    private final Map<Coordinates, Location> map;

    private LocationMap(List<Location> locations) {
        map = locations.stream()
                .collect(toMap(
                        Location::coordinates,
                        loc -> loc)
                );
    }

    public static LocationMap create(List<Location> locations) {
        return new LocationMap(locations);
    }

    public Location findLocation(Coordinates coordinates) {
        // what to do if there is no location there?
        return map.get(coordinates);
    }
}

public class Game {

    private final UserInput userInput;
    private final GameOutput gameOutput;
    //    private World world; move Player and LocationMap into World!
    private Player player;
    private LocationMap locationMap;

    public Game(UserInput userInput, GameOutput gameOutput, List<Location> locations) {
        this.userInput = userInput;
        this.gameOutput = gameOutput;
        this.locationMap = LocationMap.create(locations);
        player = new Player(locations.get(0).coordinates());
    }

    public void play() {
        do {
            gameOutput.print(locationMap.findLocation(player.currentCoordinates()).toString());
            String commandString = userInput.capture();
            // need something to take a string and convert it to a command GO N
            Command command = parseCommand(commandString);
            command.execute();
        } while (true);
    }

    private Command parseCommand(String commandString) {
        String[] args = commandString.split(" ");
        switch (args[0]) {
            case "GO":
                return new GoCommand(player, Direction.valueOf(args[1]));
        }
        throw new IllegalArgumentException();
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

interface Command {

    void execute();
}

enum Direction {
    N,
    E,
    S,
    W
}

class GoCommand implements Command {

    private final Player player;
    private final Direction direction;

    public GoCommand(Player player, Direction direction) {
        this.player = player;
        this.direction = direction;
    }

    @Override
    public void execute() {
        System.out.println("GO go go " + direction.name());
        player.move(direction);
    }
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
