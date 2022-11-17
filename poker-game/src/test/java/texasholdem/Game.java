package texasholdem;

class Game {

    private final Player[] players;
    // TODO: Add Pot (type: int)

    public Game(Player... players) {
        this.players = players;
    }

    public void deal() {
        for (Player player : players) {
            player.addCard();
            player.addCard();
        }
    }

    public void bettingRound() {
        for (Player player : players) {
            Choice choice = player.makeChoice();
            if (choice.equals(Choice.CHECK)) {
            } else if (choice.equals(Choice.BET)) {
            }
        }

        // ask each player: CHECK, BET, FOLD
        // B10
    }
}
