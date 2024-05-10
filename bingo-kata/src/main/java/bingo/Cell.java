package bingo;

public class Cell {

    private final String value;
    private boolean marked;

    public Cell(String value) {
        this.value = value;
        this.marked = false;
    }

    public String getValue() {
        return value;
    }

    public boolean isMarked() {
        return marked;
    }

    public void mark() {
        marked = true;
    }
}

