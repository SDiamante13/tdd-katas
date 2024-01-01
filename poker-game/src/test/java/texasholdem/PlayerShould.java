package texasholdem;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerShould {

    Player player = new Player(1000);

    @Test
    void startWithChips() {
        assertThat(player.currentChips()).isEqualTo(1000);
    }

    @Test
    void makeABet() {
        player.bet(100);

        assertThat(player.currentChips()).isEqualTo(900);
    }

    @Test
    void receiveHoleCardOneAtATime() {
        Card aceOfClubs = new Card(Rank.ACE, Suite.CLUBS);
        player.take(aceOfClubs);

        assertThat(player.holeCards())
                .contains(aceOfClubs);
    }

    @Test
    void forfeitTheirHoleCardsAfterFolding() {
        player.take(new Card(Rank.TWO, Suite.HEARTS));
        player.take(new Card(Rank.SEVEN, Suite.HEARTS));

        player.fold();

        assertThat(player.holeCards()).isEmpty();
    }

    @Test
    void forfeitTheirHoleCardsAfterWinningAHand() {
        player.take(new Card(Rank.TWO, Suite.HEARTS));
        player.take(new Card(Rank.SEVEN, Suite.HEARTS));

        player.win(new Pot(100));

        assertThat(player.holeCards()).isEmpty();
    }

    @Test
    void winPotAfterWinningAHand() {
        player.take(new Card(Rank.TWO, Suite.HEARTS));
        player.take(new Card(Rank.SEVEN, Suite.HEARTS));

        player.win(new Pot(100));

        assertThat(player.currentChips()).isEqualTo(1100);
    }
}


