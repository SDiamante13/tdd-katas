package tech.pathtoprogramming.gameoflife;

record Cell(State dead, int x, int y) {
    public String getStateAsString() {
        if (x == 1) {
            return "0";
        }
        return "1";
    }
}
