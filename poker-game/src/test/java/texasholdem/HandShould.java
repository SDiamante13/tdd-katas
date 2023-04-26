package texasholdem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HandShould {

    @Test
    void dropActivePlayersWhenTheyFold() {
        List<Player> players = List.of(
                () -> Choice.FOLD,
                new ActivePlayer(1000),
                new ActivePlayer(1000)
        );
        final List<Player> activePlayers = new ArrayList<>(players);
        final Hand hand = new Hand(new Pot(), activePlayers);

        hand.bettingRound();

        assertThat(hand.activePlayers())
                .hasSize(2);
    }

    @Test
    @Disabled
    void addToPotWhenPlayerMakesABet() {
        List<Player> players = List.of(
                () -> Choice.CALL,
                () -> Choice.CALL
        );
        final List<Player> activePlayers = new ArrayList<>(players);
        final Hand hand = new Hand(new Pot(), activePlayers);

        hand.bettingRound();

        assertThat(hand.pot().chips()).isEqualTo(40);
    }
}
