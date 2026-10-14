package tech.pathtoprogramming.gameoflife;

public enum State {
    ALIVE,
    DEAD;

    public static boolean next(State state, int neighbors) {
        return neighbors == 2 && state.isAlive() || neighbors == 3;
    }

    boolean isAlive() {
        return equals(ALIVE);
    }
}
