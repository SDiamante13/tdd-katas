package tech.pathtoprogramming.gameoflife;

import java.util.Set;

public record Position(int x, int y) {

    Set<Position> neighbors() {
        return Set.of(
                new Position(x - 1, y - 1),
                new Position(x, y - 1),
                new Position(x + 1, y - 1),
                new Position(x + 1, y),
                new Position(x + 1, y + 1),
                new Position(x, y + 1),
                new Position(x - 1, y + 1),
                new Position(x - 1, y));
    }
}
