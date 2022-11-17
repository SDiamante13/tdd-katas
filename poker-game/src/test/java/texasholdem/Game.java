package texasholdem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Game {

    private final List<Player> players;
    private final Pot pot;

    public Game(Pot pot, Player... players) {
        this.pot = pot;
        this.players = new ArrayList<>();
        for (Player p : players) {
            this.players.add(p);
        }
    }

    public void deal() {
        for (Player player : players) {
            player.addCard();
            player.addCard();
        }
    }

    public void bettingRound() {
        for (Player player : players) {
            Choice choice = player.makeChoice(); // choice has name, and amount
            if (choice.value().equals("B")) {
                int bettingAmount = choice.amount();
                player.takeChipsAway(bettingAmount);
                pot.add(bettingAmount);
            }

            if (choice.value().equals("F")) {
                players.remove(player);
            }
        }

        // ask each player: CHECK, BET, FOLD
        // B10
    }

}
