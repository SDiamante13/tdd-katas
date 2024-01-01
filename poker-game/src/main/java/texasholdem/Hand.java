package texasholdem;

import java.util.List;

public class Hand {

    private Pot pot;
    private List<Player> players;

    public Hand(Pot pot, List<Player> players) {
        this.pot = pot;
        this.players = players;
    }

    public void bettingRound() {
        for (Player player : players) {
            Choice choice = player.askForChoice();
            // add choice chips to pot
            System.out.println("Choice: " + choice.state());
        }
    }

    public List<Player> activePlayers() {
        return players;
    }

    public Pot pot() {
        return this.pot;
    }
}
