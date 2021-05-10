package tech.pathtoprogramming.tennis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisGameTest {

    @Test
    @DisplayName("getScore returns an initial score of 0-0")
    void getScore_initialScore() {
        TennisGame tennisGame = new TennisGame();

        String actualScore = tennisGame.getScore();

        assertThat(actualScore).isEqualTo("0-0");
    }

    @Test
    @DisplayName("score returns the new score after player 1 scores: 15-0")
    void score_player1Scores() {
        TennisGame tennisGame = new TennisGame();

        String actualScore = tennisGame.score("Player 1");

        assertThat(actualScore).isEqualTo("15-0");
    }

    @Test
    @DisplayName("score returns the new score after player 2 scores: 0-15")
    void score_player2Scores() {
        TennisGame tennisGame = new TennisGame();

        String actualScore = tennisGame.score("Player 2");

        assertThat(actualScore).isEqualTo("0-15");
    }

    @Test
    @DisplayName("score returns 30-0 when player 1 scores twice")
    void score_player1ScoresThenPlayer2Scores() {
        TennisGame tennisGame = new TennisGame();

        tennisGame.score("Player 1");
        String actualScore = tennisGame.score("Player 1");

        assertThat(actualScore).isEqualTo("30-0");
    }


}
