package bingo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BingoBoard {

    private final Map<Coordinate, Cell> spaces;

    public BingoBoard(int width, int height) {
        this.spaces = new HashMap<>();
        for (int r = 0; r < width; r++) {
            for (int c = 0; c < height; c++) {
                spaces.put(new Coordinate(r, c), null);
            }
        }
    }

    public void defineCell(String value, Coordinate coordinate) {
        if (spaces.get(coordinate) != null) {
            throw new IllegalStateException("cell already defined");
        }

        for (Map.Entry<Coordinate, Cell> coordinateCellEntry : spaces.entrySet()) {
            Coordinate c = coordinateCellEntry.getKey();
            Cell cell = coordinateCellEntry.getValue();
            if (cell != null && value.equals(cell.getValue())) {
                throw new IllegalStateException(value + " already present at " + c.x() + "," + c.y());
            }
        }

        spaces.put(coordinate, new Cell(value));
    }

    public void markCell(Coordinate coordinate) {
        if (!isInitialized()) {
            throw new IllegalStateException("board not initialized");
        }
        spaces.get(coordinate).mark();
    }

    public boolean isMarked(Coordinate coordinate) {
        return spaces.get(coordinate).isMarked();
    }

    public boolean isInitialized() {
        return spaces.keySet()
                .stream()
                .map(spaces::get)
                .noneMatch(Objects::isNull);

    }
}