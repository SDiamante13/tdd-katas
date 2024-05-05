package tech.pathtoprogramming.humanreadabletime.bowling;

class GamePrinter {

    private final Game game;

    public GamePrinter(Game game) {
        this.game = game;
    }

    public String print() {
        return "| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |\n" +
                "|---|---|---|---|---|---|---|---|---|----|\n" +
                "|" + bowlFrame(3, 2) +
                bowlFrame(7, 3) +
                bowlFrame(10) +
                bowlFrame(4, 0) +
                bowlFrame(10) +
                bowlFrame(10) +
                bowlFrame(10) +
                bowlFrame(8, 2) +
                bowlFrame(9, 0) +
                bowlFrame(10, 10, 10);
    }

    private String bowlFrame(Integer... rolls) {
        for (var r : rolls) {
            game.roll(r);
        }
        return " %s |".formatted(game.score());
    }
}
