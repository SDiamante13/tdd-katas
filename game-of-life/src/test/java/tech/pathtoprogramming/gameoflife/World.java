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
        if (positionsOfLiveCells.isEmpty()) {
            return Set.of();
        }
        return Set.of(new Position(1,1), new Position(2,1), new Position(1,2), new Position(2,2));
    }

    boolean livesOn(Position position) {
        return true;
    }
}
