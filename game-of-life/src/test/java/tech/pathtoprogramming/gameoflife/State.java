package tech.pathtoprogramming.gameoflife;

public enum State {
    ALIVE {
        @Override
        State next(int liveNeighbors) {
            return liveNeighbors == 2 || liveNeighbors == 3 ? ALIVE : DEAD;
        }
    },
    DEAD {
        @Override
        State next(int liveNeighbors) {
            return liveNeighbors == 3 ? ALIVE : DEAD;
        }
    };

    public static boolean nextOld(State state, int neighbors) {
        return neighbors == 2 && state.isAlive() || neighbors == 3;
    }

    boolean isAlive() {
        return equals(ALIVE);
    }

    abstract State next(int liveNeighbors);
}
