package tech.pathtoprogramming;

class MonopolyGame {

    private Board board;
    private Dice dice;
    private Player[] players;

    public MonopolyGame(Board board, Dice dice, Player... players) {
        this.board = board;
        this.dice = dice;
        this.players = players;
    }

    public void start() {
        int numberOfSpacesToAdvance = dice.roll();
        Property property = board.propertyAt(numberOfSpacesToAdvance);
        players[0].buyProperty(property);
    }
}
