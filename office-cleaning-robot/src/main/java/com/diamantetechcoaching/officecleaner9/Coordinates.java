package com.diamantetechcoaching.officecleaner9;

public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "[" + this.getX() + ", " + this.getY() + ", Visit]";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
