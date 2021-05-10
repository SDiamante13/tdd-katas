package tech.pathtoprogramming.tennis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.tennis.Player.PLAYER1;
import static tech.pathtoprogramming.tennis.Player.PLAYER2;

public class TennisGameTest {

    private final Scoreboard scoreboard = new Scoreboard(new PointConverter());

    @Test
    @DisplayName("getScore returns an initial score of 0-0")
    void getScore_initialScore() {
        TennisGame tennisGame = new TennisGame(scoreboard);

        String actualScore = tennisGame.getScore();

        assertThat(actualScore).isEqualTo("0-0");
    }

    @Test
    @DisplayName("score returns the new score after player 1 scores: 15-0")
    void score_player1Scores() {
        TennisGame tennisGame = new TennisGame(scoreboard);

        String actualScore = tennisGame.score(PLAYER1);

        assertThat(actualScore).isEqualTo("15-0");
    }

    @Test
    @DisplayName("score returns the new score after player 2 scores: 0-15")
    void score_player2Scores() {
        TennisGame tennisGame = new TennisGame(scoreboard);

        String actualScore = tennisGame.score(PLAYER2);

        assertThat(actualScore).isEqualTo("0-15");
    }

    @Test
    @DisplayName("score returns 30-0 when player 1 scores twice")
    void score_Player1ScoresTwice() {
        TennisGame tennisGame = new TennisGame(scoreboard);

        tennisGame.score(PLAYER1);
        String actualScore = tennisGame.score(PLAYER1);

        assertThat(actualScore).isEqualTo("30-0");
    }

    @Test
    @DisplayName("score returns 0-40 when player 2 scores three times")
    void score_Player2ScoresThreeTimes() {
        TennisGame tennisGame = new TennisGame(scoreboard);

        tennisGame.score(PLAYER2);
        tennisGame.score(PLAYER2);
        String actualScore = tennisGame.score(PLAYER2);

        assertThat(actualScore).isEqualTo("0-40");
    }

    @Test
    @DisplayName("score returns Player 2 Wins when player 2 scores four times in a row")
    void score_Player2Wins() {
        TennisGame tennisGame = new TennisGame(scoreboard);

        tennisGame.score(PLAYER2);
        tennisGame.score(PLAYER2);
        tennisGame.score(PLAYER2);
        String actualScore = tennisGame.score(PLAYER2);

        assertThat(actualScore).isEqualTo("Player 2 Wins!");
    }

    @Test
    @DisplayName("score returns Deuce when both players score 40")
    void score_deuce() {
        TennisGame tennisGame = new TennisGame(scoreboard);

        tennisGame.score(PLAYER2);
        tennisGame.score(PLAYER2);
        tennisGame.score(PLAYER2);
        tennisGame.score(PLAYER1);
        tennisGame.score(PLAYER1);
        String actualScore = tennisGame.score(PLAYER1);

        assertThat(actualScore).isEqualTo("Deuce");
    }
}
