package tech.pathtoprogramming.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DivisorGameTest {

    @Test
    void divisorGame_returnsTrue_whenNIs8() {
        DivisorGame divisorGame = new DivisorGame();

        assertThat(divisorGame.divisorGame(8)).isTrue();
    }

    @Test
    void divisorGame_returnsTrue_whenNIs1000() {
        DivisorGame divisorGame = new DivisorGame();

        assertThat(divisorGame.divisorGame(1000)).isTrue();
    }
}