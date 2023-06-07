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
        }
        throw new IllegalArgumentException("Not implemented");
    }

    private String goTo(String noun) {
        player.go(Direction.valueOf(noun));
        return locations.findLocation(player.currentCoordinates())
                .map(Location::toString)
                .orElse("You can't move there!");
    }
}
