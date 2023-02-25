package tech.pathtoprogramming.gameoflife;

public class Cell {

    private State state;

    public Cell(State state) {
        this.state = state;
    }

    public void updateState(int liveNeighbors) {
        if (liveNeighbors > 3 || liveNeighbors < 2) {
            this.state = State.DEAD;
        } else {
            this.state = State.ALIVE;
        }
    }

    public State currentState() {
        return this.state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return state == cell.state;
    }

    @Override
    public int hashCode() {
        return state != null ? state.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "state=" + state +
                '}';
    }
}
