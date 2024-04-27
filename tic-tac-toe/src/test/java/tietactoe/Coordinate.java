package tietactoe;

class Coordinate {

    private final int x;
    private final int y;
    static Locations locations = new Locations();

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Coordinate convertToCoordinate(char location) {
        return locations.getCoordinate(location);
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
