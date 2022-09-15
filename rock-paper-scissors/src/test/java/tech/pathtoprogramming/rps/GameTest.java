package tech.pathtoprogramming.rps;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tech.pathtoprogramming.rps.Result.*;

//Rock Paper Scissors
//Let's play! You have to return which player won! In case of a draw return Draw!.
//
//Examples(Input1, Input2 --> Output):
//
//"scissors", "paper" --> "Player 1 won!"
//"scissors", "rock" --> "Player 2 won!"
//"paper", "paper" --> "Draw!"
class GameTest {

    @Test
    void drawResultForSameChoices() {
        Game game = new Game();

        String result = game.shoot("scissors", "scissors");

        assertThat(result).isEqualTo("Draw!");
    }

    @Test
    void scissorsCutsPaper() {
        Game game = new Game();

        String result = game.shoot("scissors", "paper");

        assertThat(result).isEqualTo("Player 1 won!");
    }

    @Test
    void paperCoversRock() {
        Game game = new Game();

        String result = game.shoot("rock", "paper");

        assertThat(result).isEqualTo("Player 2 won!");
    }

    @Test
    void rockSmashesScissors() {
        Game game = new Game();

        String result = game.shoot("rock", "scissors");

        assertThat(result).isEqualTo("Player 1 won!");
    }
}

class Game {
    public String shoot(String player1Choice, String player2Choice) {
        if (player1Choice.equals(player2Choice)) {
            return DRAW.result();
        }

        if (player2Choice.equals("paper") && player1Choice.equals("rock")) {
            return PLAYER_2_WIN.result();
        }

        if (player1Choice.equals("rock") && player2Choice.equals("scissors")) {
            return PLAYER_1_WIN.result();
        }

        if (player1Choice.equals("scissors") && player2Choice.equals("paper")) {
            return PLAYER_1_WIN.result();
        }
        return PLAYER_1_WIN.result();
    }

}

interface Choice {

}

//could put in enum and use ordinals?
// PAPER
// ROCK
// SCISSORS

// replace the choice with Choice interface. 3 implementation Rock Paper Scissors



enum Result {
    DRAW("Draw!"),
    PLAYER_1_WIN("Player 1 won!"),
    PLAYER_2_WIN("Player 2 won!");

    private String result;

    Result(String result) {
        this.result = result;
    }

    public String result() {
        return result;
    }
}
