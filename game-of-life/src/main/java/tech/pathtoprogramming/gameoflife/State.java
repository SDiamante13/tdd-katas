package tech.pathtoprogramming.gameoflife;

enum State {

    ALIVE("O"),
    DEAD("X");

    private final String symbol;

    State(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }
}
