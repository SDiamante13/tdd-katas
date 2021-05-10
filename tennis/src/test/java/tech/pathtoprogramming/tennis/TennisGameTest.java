package tech.pathtoprogramming.tennis;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TennisGameTest {

    @Test
    @DisplayName("getScore returns an initial score of 0-0")
    void getScore_initialScore() {
        TennisGame tennisGame = new TennisGame();

        String actualScore = tennisGame.getScore();

        Assertions.assertThat(actualScore).isEqualTo("0-0");
    }
}
