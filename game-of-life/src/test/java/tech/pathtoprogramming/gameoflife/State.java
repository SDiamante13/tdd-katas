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

    abstract State next(int liveNeighbors);
}
