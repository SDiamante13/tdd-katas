package tech.pathtoprogramming.gameoflife;

import java.util.Set;

public record Position(int x, int y) {

    Set<Position> neighbors() {
        {
            if (x() == 1 && y() == 1) {
                return Set.of(
                        new Position(0, 0),
                        new Position(1, 0),
                        new Position(2, 0),
                        new Position(2, 1),
                        new Position(2, 2),
                        new Position(1, 2),
                        new Position(0, 2),
                        new Position(0, 1));

            }
        }
        if (x() == 2 && y() == 1) {
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
        if (x() == 1 && y() == 2) {
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
        if (x() == 2 && y() == 2) {
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
}
