package tech.pathtoprogramming.tennis;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TennisGameTest {

    @Test
    @DisplayName("play returns an initial score of 0-0")
    void play_initialScore() {
        TennisGame tennisGame = new TennisGame();

        String actualScore = tennisGame.play();

        Assertions.assertThat(actualScore).isEqualTo("0-0");
    }
}
