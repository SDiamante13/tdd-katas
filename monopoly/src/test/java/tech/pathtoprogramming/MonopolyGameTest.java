package tech.pathtoprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonopolyGameTest {
    private static final int BALTIC_AVENUE = 3;
    private static final int STARTING_MONEY = 1500;

    @Test
    void playerBuysMediterraneanAvenue() {
        Dice fakeDice = new FakeDice();
        Player player1 = new Player();
        Board fakeBoard = new FakeBoard();

        MonopolyGame monopolyGame = new MonopolyGame(fakeBoard, fakeDice, player1);

        monopolyGame.start();

        assertThat(player1.money()).isEqualTo(STARTING_MONEY - 60);
        assertThat(player1.location()).isEqualTo(BALTIC_AVENUE);
    }
}



