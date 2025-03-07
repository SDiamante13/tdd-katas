package bingo;

public class BingoBoard {



    // String[][] -> Cell[][] -> Map<Coordinate, Cell> -> Spaces
    private final Cell[][] board;

    private final int width;
    private final int height;

    public BingoBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new Cell[width][height];

    }

    private String getCell(int x, int y){
        Cell cell = board[x][y];
        return cell == null ? null : cell.value;
    }

    private void setCell(int x, int y, String value){
        board[x][y] = new Cell(value, false);
    }

    public void defineCell(int x, int y, String value) {
        if (getCell(x, y) != null) {
            throw new IllegalStateException("cell already defined");
        }
        for (int x1 = 0; x1 < width; x1++) {
            for (int y1 = 0; y1 < height; y1++) {
                if (value.equals(getCell(x1, y1)))
                    throw new IllegalStateException(value + " already present at " + x1 + "," + y1);
            }
        }
        setCell(x, y, value);
    }

    public void markCell(int x, int y) {
        if (!isAllCellsDefined()) {
            throw new IllegalStateException("board not initialized");
        }
        board[x][y] = new Cell(getCell(x,y), true);
    }

    public boolean isMarked(int x, int y) {
        return board[x][y].marked;
    }

    public boolean isAllCellsDefined() {
        for (int x1 = 0; x1 < width; x1++) {
            for (int y1 = 0; y1 < height; y1++) {
                if (getCell(x1, y1) == null)
                    return false;
            }
        }

        return true;
    }

    private record Cell(String value, boolean marked) {

    }
}