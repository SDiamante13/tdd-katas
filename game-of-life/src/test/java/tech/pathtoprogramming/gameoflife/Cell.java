package tech.pathtoprogramming.gameoflife;

record Cell(State dead, int x, int y) {
    public String getStateAsString() {
        if (dead.equals(State.ALIVE)) {
            return "1";
        }
        return "0";
    }
}
