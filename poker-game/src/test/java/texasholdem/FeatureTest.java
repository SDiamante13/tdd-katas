package texasholdem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    // move to Player
    @Test
    void players_start_with_100_chips() {
        Player player = new Player();

        assertThat(player.chips()).isEqualTo(100);
    }

    // move to Player
    @Test
    void each_player_can_choose_to_check() {
        playerChoices(spyPlayer1, check());
        playerChoices(spyPlayer2, check());

        new Hand(Pot.EMPTY(), players)
                .bet();

        assertThat(players)
                .extracting(Player::chips)
                .containsOnly(100, 100);
    }

    @Test
    void each_player_can_choose_to_bet() {
        playerChoices(spyPlayer1, check());
        playerChoices(spyPlayer2, bet(10));

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
        playerChoices(spyPlayer1, bet(50));
        playerChoices(spyPlayer2, fold());

        Pot pot = Pot.EMPTY();
        Hand hand = new Hand(pot, players);

        hand.bet();

        assertThat(players)
                .extracting(Player::chips)
                .containsOnly(100, 100);
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
        // game keeps state of players and hands
    void playAGameWhereBothPlayersPlayOneHand() {
        playerChoices(spyPlayer1, bet(50), bet(20));
        playerChoices(spyPlayer2, bet(50), bet(20));

        nextCardsAre("A", "K", "2");

        Game game = new Game(players);
        game.start();

        assertThat(players)
                .extracting(Player::chips)
                .containsOnly(30, 30);
//        assertThat(game.hand().pot().amount()).isEqualTo(100);
//        assertThat(game.hand().communityCards()).isEqualTo(List.of("A", "K", "2"));
//        assertThat(players)
//                .extracting(Player::chips)
//                .containsOnly(30, 30);


    }

    // move tests to unit tests

    // write test for this
    // B?, C?, F?
    //B10
    //Player Bets. Pot: 10
    //B?, C?, F?
    //B10
    //Player Bets. Pot: 20
    //Community Cards: [A, K, 2]
    //B?, C?, F?
    //B10
    //Player Bets. Pot: 30
    //B?, C?, F?
    //B10
    //Player Bets. Pot: 40
    // Player cards: [K, 8]
    // Player chips: 80
    // Player cards: [K, 9]
    // Player chips: 80

    private void nextCardsAre(String... cards) {

    }


    private void playerChoices(Player player, Choice... choices) {
        for (int index = 0; index < choices.length; index++) {
            doReturn(choices[index])
                    .doReturn(choices[choices.length - 1])
                    .when(player).makeChoice();
        }
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

    // refactor from spy to fake that stubs user input
    private Player[] assignSpyPlayers() {
        spyPlayer1 = spy(new Player());
        spyPlayer2 = spy(new Player());
        return new Player[]{spyPlayer1, spyPlayer2};
    }
}
