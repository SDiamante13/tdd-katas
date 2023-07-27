package texasholdem;

import java.util.List;
import java.util.stream.Collectors;

public class Hand {

    private Pot pot;
    private List<Player> activePlayers;

    public Hand(Pot pot, List<Player> activePlayers) {
        this.pot = pot;
        this.activePlayers = activePlayers;
    }

    public void bettingRound() {
        this.activePlayers = activePlayers.stream()
                .filter(Player::didNotFold)
                .collect(Collectors.toList());
    }

    public List<Player> activePlayers() {
        return activePlayers;
    }

    public Pot pot() {
        return this.pot;
    }
}
