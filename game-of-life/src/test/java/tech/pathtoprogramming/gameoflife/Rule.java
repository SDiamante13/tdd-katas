package tech.pathtoprogramming.gameoflife;

public class Rule {
    public static boolean satisfies(State state, int neighbors) {
        return neighbors == 2 && state.equals(State.ALIVE) || neighbors == 3;
    }
}
