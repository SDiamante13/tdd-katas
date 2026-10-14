package tech.pathtoprogramming.gameoflife;


import java.util.Set;
import java.util.stream.Collectors;

public record World(Set<Position> positionsOfLiveCells) {

    public static World empty() {
        return new World(Set.of());
    }

    public World next() {
        return new World(candidates().stream().filter(this::livesOn).collect(Collectors.toSet()));
    }

    Set<Position> candidates() {
        return positionsOfLiveCells;
    }

    boolean livesOn(Position position) {
        Set<Position> possibleNeighbors = position.neighbors();
        int neighbors = countOfLiveNeighbors(positionsOfLiveCells, possibleNeighbors);
        return Rule.satisfies(neighbors);
    }

    static int countOfLiveNeighbors(Set<Position> positionsOfLiveCells, Set<Position> possibleNeighbors) {
        return Math.toIntExact(positionsOfLiveCells.stream()
                .filter(possibleNeighbors::contains)
                .count());
    }

}
