package texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static texasholdem.Choice.*;

class FeatureTest {

    private Player spyPlayer1;
    private Player spyPlayer2;
    private Player[] players;

    @BeforeEach
    void setUp() {
        players = assignSpyPlayers();
    }

    @Test
    void each_player_is_dealt_two_hole_cards() {
        assertThat(players)
                .extracting(Player::numberOfCards)
                .contains(0, 0);

        new Hand(Pot.EMPTY(), players)
                .deal();

        assertThat(players)
                .extracting(Player::numberOfCards)
                .contains(2, 2);
    }

    @Test
    void players_start_with_100_chips() {
        Player player = new Player();

        assertThat(player.chips()).isEqualTo(100);
    }

    @Test
    void each_player_can_choose_to_check() {
        stubPlayerChoiceTo(spyPlayer1, check());
        stubPlayerChoiceTo(spyPlayer2, check());

        new Hand(Pot.EMPTY(), players)
                .bet();

        assertThat(players)
                .extracting(Player::chips)
                .containsOnly(100, 100);
    }

    @Test
    void each_player_can_choose_to_bet() {
        stubPlayerChoiceTo(spyPlayer1, check());
        stubPlayerChoiceTo(spyPlayer2, bet(10));

        Pot pot = Pot.EMPTY();
        Hand hand = new Hand(pot, players);

        hand.bet();

        assertThat(players)
                .extracting(Player::chips)
                .containsOnly(100, 90);
        assertThat(pot.amount()).isEqualTo(10);
    }

    @Test
    void each_player_can_choose_to_fold_their_cards() {
        stubPlayerChoiceTo(spyPlayer1, bet(50));
        stubPlayerChoiceTo(spyPlayer2, fold());

        Pot pot = Pot.EMPTY();
        Hand hand = new Hand(pot, players);

        hand.bet();

        assertThat(players)
                .extracting(Player::chips)
                .containsOnly(100, 100);
    }

    private void stubPlayerChoiceTo(Player player, Choice choice) {
        doReturn(choice)
                .when(player).makeChoice();
    }

    @Test
    void state_flop() {
        // TODO: add CommunityCards class that gets 3, 1, 1 cards
    }

//    private UserInput responseWith(String input) {
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
//        System.setIn(inputStream);
//
//        UserInput userInput = new UserInput(inputStream);
//        return userInput;
//    }

    private Player[] assignSpyPlayers() {
        spyPlayer1 = spy(new Player());
        spyPlayer2 = spy(new Player());
        return new Player[]{spyPlayer1, spyPlayer2};
    }
}
