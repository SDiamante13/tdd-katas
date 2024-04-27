package tietactoe;

class Grid {

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

enum Mark {
    X('X'), O('O');

    private char value;

    Mark(char value) {
        this.value = value;
    }

    public char value() {
        return this.value;
    }

    Mark rotate() {
        return equals(X) ? O : X;
    }
}
class TicTacToe {

    private final Grid grid;
    private Mark currentMark = Mark.X;

    public TicTacToe() {
        grid = Grid.initialize();
    }

    public void take(char location) {
        Coordinate coordinate = Coordinate.convertToCoordinate(location);
        grid.placeMarkOn(coordinate, currentMark);
        currentMark = currentMark.rotate();
    }

    @Override
    public String toString() {
        return grid.print();
    }
}
