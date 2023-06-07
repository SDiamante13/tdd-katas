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
                player.go(noun);
                Location currentLocation = locations.findLocation(player.currentCoordinates());
                return currentLocation.toString();
        }
        throw new IllegalArgumentException("Wrong");
    }
}
