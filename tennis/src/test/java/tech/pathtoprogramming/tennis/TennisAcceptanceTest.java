package tech.pathtoprogramming.tennis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TennisAcceptanceTest {
    StandingsCalculator standingsCalculator = new StandingsCalculator();
    Player playerA = new Player();
    Player playerB = new Player();

    Game game = new Game(standingsCalculator, playerA, playerB);

    @Test
    void playAGameOfTennis() {
        assertThat(game.score()).isEqualTo("love:love");

        game.playPoint(playerA);
        assertThat(game.score()).isEqualTo("fifteen:love");

        game.playPoint(playerB);
        assertThat(game.score()).isEqualTo("fifteen:fifteen");

        game.playPoint(playerB);
        assertThat(game.score()).isEqualTo("fifteen:thirty");

        game.playPoint(playerA);
        assertThat(game.score()).isEqualTo("thirty:thirty");

        game.playPoint(playerB);
        assertThat(game.score()).isEqualTo("thirty:forty");

        game.playPoint(playerB);
        assertThat(game.score()).isEqualTo("PlayerB won");
    }
}
