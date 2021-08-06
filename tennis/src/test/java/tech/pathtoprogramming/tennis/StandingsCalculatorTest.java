package tech.pathtoprogramming.tennis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StandingsCalculatorTest {

    StandingsCalculator standingsCalculator = new StandingsCalculator();

    @Test
    void calculate_returnsScoreInTennisFormat() {
        int playerAScore = 1;
        int playerBScore = 0;

        String result = standingsCalculator.calculate(playerAScore, playerBScore);

        assertThat(result).isEqualTo("fifteen:love");
    }

    @Test
    void calculate_returnsScoreInTennisFormat_thirtyForty() {
        int playerAScore = 2;
        int playerBScore = 3;

        String result = standingsCalculator.calculate(playerAScore, playerBScore);

        assertThat(result).isEqualTo("thirty:forty");
    }

    @Test
    void calculate_returnsDeuce_whenTheScoresAreEqualAndAboveTwo() {
        int playerAScore = 3;
        int playerBScore = 3;

        String result = standingsCalculator.calculate(playerAScore, playerBScore);

        assertThat(result).isEqualTo("deuce");
    }

    @Test
    void calculate_returnsAdvantagePlayerA_whenPlayerAHasAdvantage() {
        int playerAScore = 4;
        int playerBScore = 3;

        String result = standingsCalculator.calculate(playerAScore, playerBScore);

        assertThat(result).isEqualTo("advantage PlayerA");
    }

    @Test
    void calculate_returnsAdvantagePlayerB_whenPlayerBHasAdvantage() {
        int playerAScore = 3;
        int playerBScore = 4;

        String result = standingsCalculator.calculate(playerAScore, playerBScore);

        assertThat(result).isEqualTo("advantage PlayerB");
    }

    @Test
    void calculate_returnsTheWinner_PlayerA() {
        int playerAScore = 5;
        int playerBScore = 3;

        String result = standingsCalculator.calculate(playerAScore, playerBScore);

        assertThat(result).isEqualTo("PlayerA won");
    }

    @Test
    void calculate_returnsTheWinner_PlayerB() {
        int playerAScore = 3;
        int playerBScore = 5;

        String result = standingsCalculator.calculate(playerAScore, playerBScore);

        assertThat(result).isEqualTo("PlayerB won");
    }
}