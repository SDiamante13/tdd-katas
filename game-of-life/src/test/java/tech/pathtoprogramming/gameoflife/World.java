package tech.pathtoprogramming.gameoflife;


import java.util.Set;

public record World(Set<Position> positionsOfLiveCells) {

    public static World empty() {
        return new World(Set.of());
    }

    public World next() {
        return this;
    }
}
