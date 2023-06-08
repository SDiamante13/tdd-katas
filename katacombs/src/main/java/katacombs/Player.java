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
        switch (direction) { // repeated switch cases - polymorphism!
            case N:
                this.currentCoordinates = currentCoordinates.north();
                break;
            case E:
                this.currentCoordinates = currentCoordinates.east();
                break;
            case S:
                this.currentCoordinates = currentCoordinates.south();
                break;
            case W:
                this.currentCoordinates = currentCoordinates.west();
                break;
            default:
                throw new IllegalArgumentException("No direction called: " + direction);
        }
    }

    Coordinates look(Direction direction) {
        switch (direction) {
            case N:
                return currentCoordinates.north();
            case E:
                return currentCoordinates.east();
            case S:
                return currentCoordinates.south();
            case W:
                return currentCoordinates.west();
            default:
                throw new IllegalArgumentException("No direction called: " + direction);
        }
    }
}
