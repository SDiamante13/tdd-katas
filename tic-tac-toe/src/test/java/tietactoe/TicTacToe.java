package tietactoe;

class TicTacToe {

    private final char[][] grid = new char[3][3];

    public TicTacToe() {
        int count = 1;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                grid[x][y] = Character.forDigit(count++, 10);
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                result += "| %s ".formatted(grid[x][y]);
                if (x == 2) {
                    result += "|\n";
                }
            }
        }
        return "+---+---+---+\n" +
                result +
                "+---+---+---+\n";
    }

    public void take(char location) {
        Coordinate  coordinate = convertToCoordinate(location);
        grid[coordinate.x()][coordinate.y()] = 'X';
    }

    private Coordinate convertToCoordinate(char location) {
        return new Coordinate(1,1);
    }

    private class Coordinate {
        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x() {
            return x;
        }

        public int y() {
            return y;
        }
    }
}
