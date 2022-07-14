package tech.pathtoprogramming;

public class GameBoard {
    private Dice dice;
    private Player[] players;
    private Spaces spaces;

    public GameBoard(Dice dice, Spaces spaces, Player... players) {
        this.dice = dice;
        this.spaces = spaces;
        this.players = players;
    }

    public void start() {
        for (Player player : players) {
            DiceRoll diceRoll = dice.rollTwoDice();
            player.moveSpaces(diceRoll.total());
            Property currentSpace = spaces.at(player.location());
            player.buy(currentSpace);
            // player should move around a board, not a location
        }
    }
}
