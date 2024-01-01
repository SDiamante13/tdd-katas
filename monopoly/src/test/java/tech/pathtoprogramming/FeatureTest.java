package tech.pathtoprogramming;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class FeatureTest {


    private Dice stubbedDice;

    // roll a 6 buy Oriental Avenue $100
    // roll an 11 buy St. Charles Place $140
    @Test
    void playerTakesTheirTurn_buysProperty() {
        stubbedDice = Mockito.mock(Dice.class);
        BDDMockito.given(stubbedDice.rollTwoDice())
                .willReturn(new DiceRoll(5, 1), new DiceRoll(6, 5));
        Player player1 = new Player();
        Player player2 = new Player();
        GameBoard gameBoard = new GameBoard(stubbedDice, new Spaces(), player1, player2);

        gameBoard.start(); // iterate through two players turns then end game

        assertThat(player1.location()).isEqualTo(6);
        assertThat(player1.money()).isEqualTo(1500 - 100);

        assertThat(player2.location()).isEqualTo(11);
        assertThat(player2.money()).isEqualTo(1500 - 140);
    }

    // first player buys a property, second player lands on that property and pays the player rent
    
}
