package texasholdem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Hand {


    // Game object tracks the players involves at the Table
    // There can be up to 9 players at a poker table

    // Need a way to keep track of hands, hash map? YAGNI?

    //Should Hand be a domain object

    // A game of poker has many hands.
    // hands have temorary state
    // hands have different players involved, some fold, some stay
    //
    private final Pot pot;
    private final List<Player> players;

    public Hand(Pot pot, Player... players) {
        this.pot = pot;
        this.players = new ArrayList<>();
        this.players.addAll(Arrays.asList(players));
    }

    // ante up!

    // betting round

    // deal the flop


    public void deal() {
        for (Player player : players) {
            player.addCard();
            player.addCard();
        }
    }

    public void bet() {
        for (Player player : players) {
            if (player.didNotFold()) {
                Choice choice = player.makeChoice(); // choice has name, and amount
                if (choice.value().equals("B")) {
                    int bettingAmount = choice.amount();
                    player.takeChipsAway(bettingAmount);
                    pot.add(bettingAmount);
                }

                if (choice.choseToFold()) {
                    player.fold();
                }
            }
        }

        // Next State is -> FLOP

        // Rounds
        // ANTE/BLINDS, BET, FLOP, BET, TURN, BET, RIVER

        // ask each player: CHECK, BET, FOLD
        // B10
    }

}
