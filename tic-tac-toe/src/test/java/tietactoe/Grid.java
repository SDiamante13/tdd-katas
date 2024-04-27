package tietactoe;

public class Grid {

    private final char[][] squares = new char[3][3];

    public static Grid initialize() {
        return new Grid();
    }

    private Grid() {
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

    public void placeMarkOn(Coordinate coordinate, Mark mark) {
        squares[coordinate.x()][coordinate.y()] = mark.value();
    }
}
