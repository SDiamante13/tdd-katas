package texasholdem;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class FeatureTest {

    @Test
    void each_player_is_dealt_two_hole_cards() {
        Player[] players = getPlayers(null, null);
        assertThat(players).extracting(Player::numberOfCards)
                .contains(0, 0);

        new Game(players)
                .deal();

        assertThat(players)
                .extracting(Player::numberOfCards)
                .contains(2, 2);
    }

    @Test
    void players_start_with_100_chips() {
        Player player = new Player(null);

        assertThat(player.chips()).isEqualTo(100);
    }

    @Test
    void each_player_can_choose_to_check() {
        Player[] players = getPlayers(responseWith("C"), null);

        new Game(players)
                .bettingRound();

        assertThat(players)
                .extracting(Player::chips)
                .contains(100, 100);
    }

//    @Test
//    void each_player_can_choose_to_bet() {
//        Player[] players = getPlayers(responseWith("C"), responseWith("B10"));
//
//        new Game(players)
//                .bettingRound();
//
//        assertThat(players)
//                .extracting(Player::chips)
//                .contains(100, 90);
//        // assert that pot has 10 in it
//    }

    @Test
    void state_flop() {
        // TODO: add CommunityCards class that gets 3, 1, 1 cards
    }

    private UserInput responseWith(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);

        UserInput userInput = new UserInput(inputStream);
        return userInput;
    }

    private Player[] getPlayers(UserInput inputOfPlayer1, UserInput inputOfPlayer2) {
        return new Player[]{new Player(inputOfPlayer1), new Player(inputOfPlayer2)};
    }
}
