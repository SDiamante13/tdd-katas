package tietactoe;

public class Grid {

    private final char[][] squares = new char[3][3];
    private final Locations locations;

    public Grid() {
        this.locations = new Locations();
        initialize();
    }

    private void initialize() {
        int count = 1;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                squares[x][y] = Character.forDigit(count++, 10);
            }
        }
    }

    public String print() {
        String result = "";
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                result += "| %s ".formatted(squares[x][y]);
                if (x == 2) {
                    result += "|\n";
                }
            }
        }
        return "+---+---+---+\n" +
                result +
                "+---+---+---+\n";
    }

    public void placeMarkOn(Mark mark, char location) {
        Coordinate coordinate = locations.getCoordinate(location);
        squares[coordinate.x()][coordinate.y()] = mark.value();
    }
}
