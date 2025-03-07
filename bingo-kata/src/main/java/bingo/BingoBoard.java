package bingo;

public class BingoBoard {

    private final String[][] cells;
    private final boolean[][] marked;
    private final int width;
    private final int height;

    public BingoBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new String[width][height];
        this.marked = new boolean[width][height];
    }

    public void defineCell(int x, int y, String value) {
        if (cells[x][y] != null) {
            throw new IllegalStateException("cell already defined");
        }
        for (int x1 = 0; x1 < width; x1++) {
            for (int y1 = 0; y1 < height; y1++) {
                if (value.equals(cells[x1][y1]))
                    throw new IllegalStateException(value + " already present at " + x1 + "," + y1);
            }
        }
        cells[x][y] = value;
    }

    public void markCell(int x, int y) {
        if (!isInitialized()) {
            throw new IllegalStateException("board not initialized");
        }
        marked[x][y] = true;
    }

    public boolean isMarked(int x, int y) {
        return marked[x][y];
    }

    public boolean isInitialized() {
        for (String[] row : cells) {
            for (String col : row) {
                if (col == null)
                    return false;
            }
        }
        return true;
    }

}