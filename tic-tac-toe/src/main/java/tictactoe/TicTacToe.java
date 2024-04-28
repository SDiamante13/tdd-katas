package tictactoe;

import java.util.ArrayList;
import java.util.List;

class TicTacToe {

    private final Grid grid;
    private Player currentPlayer;
    private final List<Player> players = new ArrayList<>();

    public TicTacToe(String... playerNames) {
        grid = new Grid();
        players.add(new Player(playerNames[0], Mark.X));
        players.add(new Player(playerNames[1], Mark.O));
        currentPlayer = players.get(0);
    }

    public void take(char locationDto) {
        if (gameIsOver()) {
            return;
        }
        Location location = Location.of(locationDto);
        grid.placeMarkOn(currentPlayer.mark(), location);
        currentPlayer = players.indexOf(currentPlayer) == 0 ?
                players.get(1) :
                players.get(0);
    }

    public boolean gameIsOver() {
        return !grid.winStatus().isEmpty();
    }

    public Player currentPlayer() {
        return this.currentPlayer;
    }

    public String printPlayers() {
        return "%s and %s added to the game"
                .formatted(players.get(0), players.get(1));
    }

    @Override
    public String toString() {
        return grid.print();
    }
}
