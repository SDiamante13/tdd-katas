package katacombs;

class Player {

    private Coordinates currentCoordinates;

    Player() {
        this(new Coordinates(0, 0));
    }

    Player(Coordinates currentCoordinates) {
        this.currentCoordinates = currentCoordinates;
    }

    Coordinates currentCoordinates() {
        return currentCoordinates;
    }

    public void go(String direction) {
        this.currentCoordinates = currentCoordinates.moveNorth();
    }
}
