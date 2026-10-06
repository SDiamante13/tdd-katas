package tech.pathtoprogramming.gameoflife;

record Cell(State state, int x, int y) {
    public String stateAsString() {
        return state.asString();
    }
}
