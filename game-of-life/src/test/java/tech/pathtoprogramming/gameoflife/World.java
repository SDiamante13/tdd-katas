package tech.pathtoprogramming.gameoflife;


import java.util.Collection;
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
        return liveCellsPlusTheNeighborsOfTheLiveCells();
    }

    private Set<Position> liveCellsPlusTheNeighborsOfTheLiveCells() {
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

    boolean livesOn(Position position) {
        Set<Position> positionsOfNeighbors = position.neighbors();
        int neighbors = countOfLiveNeighbors(positionsOfNeighbors);
        return Rule.satisfies(position.hasLiveCell(positionsOfLiveCells), neighbors);
    }

    private int countOfLiveNeighbors(Set<Position> positionsOfNeighbors) {
        return Math.toIntExact(positionsOfLiveCells.stream()
                .filter(positionsOfNeighbors::contains)
                .count());
    }

}
