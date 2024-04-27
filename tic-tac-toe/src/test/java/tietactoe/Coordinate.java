package tietactoe;

class Coordinate {

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Coordinate convertToCoordinate(char location) {
        if (location == '2') {
            return new Coordinate(1,0);
        }
        if (location == '5') {
            return new Coordinate(1,1);
        }
        return new Coordinate(2,1);
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
