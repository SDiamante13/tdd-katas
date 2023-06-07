package katacombs;

class World {

    private final Player player;
    private final Locations locations;

    World(Player player, Locations locations) {
        this.player = player;
        this.locations = locations;
    }

    public String respond(Action action, String noun) {
        switch (action) {
            case GO:
                player.go(Direction.valueOf(noun));
                return locations.findLocation(player.currentCoordinates()).toString();
        }
        throw new IllegalArgumentException("Not implemented");
    }
}
