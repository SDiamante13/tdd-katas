package texasholdem;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerShould {

    ActivePlayer player = new ActivePlayer(1000);


    @Test
    void startWithChips() {
        assertThat(player.chips()).isEqualTo(1000);
    }

    @Test
    void makeABet() {
        player.bet(100);

        assertThat(player.chips()).isEqualTo(900);
    }

    @Test
    void receiveHoleCardOneAtATime() {
        Card aceOfClubs = new Card(Rank.ACE, Suite.CLUBS);
        player.receiveHoleCards(aceOfClubs);

        assertThat(player.holeCards())
                .contains(aceOfClubs);
    }

    @Test
    void forfeitTheirHoleCardsAfterFolding() {
        player.receiveHoleCards(new Card(Rank.TWO, Suite.HEARTS));
        player.receiveHoleCards(new Card(Rank.SEVEN, Suite.HEARTS));

        player.fold();

        assertThat(player.holeCards()).isEmpty();
    }

    @Test
    void forfeitTheirHoleCardsAfterWinningAHand() {
        player.receiveHoleCards(new Card(Rank.TWO, Suite.HEARTS));
        player.receiveHoleCards(new Card(Rank.SEVEN, Suite.HEARTS));

        player.win(new Pot(100));

        assertThat(player.holeCards()).isEmpty();
    }

    @Test
    void winPotAfterWinningAHand() {
        player.receiveHoleCards(new Card(Rank.TWO, Suite.HEARTS));
        player.receiveHoleCards(new Card(Rank.SEVEN, Suite.HEARTS));

        player.win(new Pot(100));

        assertThat(player.chips()).isEqualTo(1100);
    }
}


