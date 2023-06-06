package katacombs;

public class World {

    private final Player player;
    private final Locations locations;

    public World(Player player, Locations locations) {
        this.player = player;
        this.locations = locations;
    }

    void executeAction(String commandString) {
        // ParsedCommand - action: Action (enum), noun: Noun (enum)
        String[] args = commandString.split(" ");
        switch (args[0]) {
            case "GO":
                player.move(Direction.valueOf(args[1]));
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public Location currentLocation() {
        return locations.findLocation(player.currentCoordinates());
    }
}