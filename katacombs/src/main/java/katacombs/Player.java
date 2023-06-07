package katacombs;

class Player {

    private Coordinates currentCoordinates;

    Player(Coordinates currentCoordinates) {
        this.currentCoordinates = currentCoordinates;
    }

    Coordinates currentCoordinates() {
        return currentCoordinates;
    }

    public void go(Direction direction) {
        switch (direction) {
            case S:
                this.currentCoordinates = currentCoordinates.moveSouth();
                break;
            case W:
                this.currentCoordinates = currentCoordinates.moveWest();
                break;
            case E:
                this.currentCoordinates = currentCoordinates.moveEast();
                break;
            default:
                this.currentCoordinates = currentCoordinates.moveNorth();
                break;
        }
    }
}
