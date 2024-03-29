package katacombs;

class Coordinates {

    private final int x;
    private final int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates north() {
        return new Coordinates(x, y + 1);
    }

    public Coordinates east() {
        return new Coordinates(x + 1, y);
    }

    public Coordinates south() {
        return new Coordinates(x, y - 1);
    }

    public Coordinates west() {
        return new Coordinates(x - 1, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
