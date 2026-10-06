package tech.pathtoprogramming.gameoflife;


public record World() {
    public static World empty() {
        return new World();
    }

    public World next() {
        return World.empty();
    }
}
