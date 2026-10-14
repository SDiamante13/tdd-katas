package tech.pathtoprogramming.gameoflife;

public class Rule {
    public static boolean satisfies(boolean isAlive, int neighbors) {
        return neighbors == 2 && isAlive || neighbors == 3;
    }
}
