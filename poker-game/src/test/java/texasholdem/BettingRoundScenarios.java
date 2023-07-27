package texasholdem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BettingRoundScenarios {

    @Test // common scenario
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
    void addToPotWhenPlayerMakesABet() {
        Player danielN = givenPlayerBets(Choice.CALL);
        Player danPolk = givenPlayerBets(Choice.CALL);

        List<Player> players = List.of(
                danielN,
                danPolk
        );
        final List<Player> activePlayers = new ArrayList<>(players);
        final Hand hand = new Hand(new Pot(), activePlayers);

        hand.bettingRound();

        assertThat(hand.pot().chips()).isEqualTo(40);
    }

    private static Player givenPlayerBets(Choice choice) {
        Choice choice2 = choice;
        Player danPolk = () -> choice2;
        return danPolk;
    }
}
