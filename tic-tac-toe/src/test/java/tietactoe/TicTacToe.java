package tietactoe;

class TicTacToe {

    private final char[][] grid = new char[3][3];
    private char playerMark = 'X';

    public TicTacToe() {
        initialize();
    }

    private void initialize() {
        int count = 1;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                grid[x][y] = Character.forDigit(count++, 10);
            }
        }
    }

    @Override
    public String toString() {
        return print();
    }

    private String print() {
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
        Coordinate coordinate = Coordinate.convertToCoordinate(location);
        placeMarkOn(coordinate, playerMark);
        playerMark = 'O';
    }

    private void placeMarkOn(Coordinate coordinate, char playerMark) {
        grid[coordinate.x()][coordinate.y()] = playerMark;
    }
}
