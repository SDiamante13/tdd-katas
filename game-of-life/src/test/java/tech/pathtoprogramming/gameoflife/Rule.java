package tech.pathtoprogramming.gameoflife;

public class Rule {
    // This can be a chain of responsibility with various rules
    public static boolean satisfies(int neighbors) {
        // rule is
        // if alive cell has 2 or 3 neighbors it lives
        return neighbors == 3;
    }
}
