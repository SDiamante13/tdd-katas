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
        // Given a position what neighbors does it have - this will be a set of Positions
        // Then how many of those neighbors are alive - meaning compare it to the position of live cells
        Set<Position> possibleNeighbors = neighbors(position);
        int neighbors = countOfLiveNeighbors(positionsOfLiveCells, possibleNeighbors);
        return Rule.satisfies(neighbors);
    }

    private Set<Position> neighbors(Position position) {
        if (position.x() == 1 && position.y() == 1) {
            return Set.of(
                    new Position(0,0),
                    new Position(1, 0),
                    new Position(2, 0),
                    new Position(2, 1),
                    new Position(2, 2),
                    new Position(1, 2),
                    new Position(0, 2),
                    new Position(0, 1));

        }
        if (position.x() == 2 && position.y() == 1) {
            return Set.of(
                    new Position(1,0),
                    new Position(2, 0),
                    new Position(3, 0),
                    new Position(3, 1),
                    new Position(3, 2),
                    new Position(2, 2),
                    new Position(1, 2),
                    new Position(1, 1));
        }
        if (position.x() == 1 && position.y() == 2) {
            return Set.of(
                    new Position(0,1),
                    new Position(1, 1),
                    new Position(2, 1),
                    new Position(2, 2),
                    new Position(2, 3),
                    new Position(1, 3),
                    new Position(0, 3),
                    new Position(0, 2));
        }
        if (position.x() == 2 && position.y() == 2) {
            return Set.of(
                    new Position(1,0),
                    new Position(2, 0),
                    new Position(3, 0),
                    new Position(3, 1),
                    new Position(3, 2),
                    new Position(2, 2),
                    new Position(1, 2),
                    new Position(1, 1));
        }
        return Set.of();
    }

    static int countOfLiveNeighbors(Set<Position> positionsOfLiveCells, Set<Position> possibleNeighbors) {
        return Math.toIntExact(positionsOfLiveCells.stream()
                .filter(possibleNeighbors::contains)
                .count());
    }

}
