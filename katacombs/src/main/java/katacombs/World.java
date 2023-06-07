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
                return goTo(noun);
            case LOOK:
                return lookTo(noun);
        }
        throw new IllegalArgumentException("Not implemented");
    }

    private String lookTo(String noun) {
        Coordinates lookCoordinates = player.look(Direction.valueOf(noun));
        return locations.findLocation(lookCoordinates)
                .map(Location::lookDescription)
                .orElse("Nothing interesting to look at there!");
    }

    private String goTo(String noun) {
        player.go(Direction.valueOf(noun));
        return locations.findLocation(player.currentCoordinates())
                .map(Location::toString)
                .orElse("You can't move there!");
    }

    public Location playerLocation() {
        return locations.findLocation(player.currentCoordinates())
                .orElseThrow(IllegalArgumentException::new);
    }
}
