package tech.pathtoprogramming.gameoflife;


import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public record World(Set<Position> positionsOfLiveCells) {

    public static World empty() {
        return new World(Set.of());
    }

    public World next() {
        return new World(candidates().stream()
                .filter(position -> nextStateAt(position) == State.ALIVE)
                .collect(Collectors.toSet()));
    }

    Set<Position> candidates() {
        Set<Position> neighborsOfTheLiveCells = getNeighborsOfTheLiveCells(positionsOfLiveCells);
        neighborsOfTheLiveCells.addAll(positionsOfLiveCells);
        return neighborsOfTheLiveCells;
    }

    private static Set<Position> getNeighborsOfTheLiveCells(Set<Position> positionsOfLiveCells) {
        return positionsOfLiveCells.stream()
                .map(Position::neighbors)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    private State nextStateAt(Position position) {
        int liveNeighbors = countOfLiveNeighbors(position.neighbors());
        State currentState = stateAt(position);
        return currentState.next(liveNeighbors);
    }

    private int countOfLiveNeighbors(Set<Position> positionsOfNeighbors) {
        return Math.toIntExact(positionsOfLiveCells.stream()
                .filter(positionsOfNeighbors::contains)
                .count());
    }

    private State stateAt(Position position) {
        return positionsOfLiveCells.contains(position) ? State.ALIVE : State.DEAD;
    }
}
