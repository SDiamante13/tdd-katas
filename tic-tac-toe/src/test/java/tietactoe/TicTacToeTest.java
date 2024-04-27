package tietactoe;

import org.approvaltests.Approvals;
import org.approvaltests.StoryBoard;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@UseReporter(QuietReporter.class)
class TicTacToeTest {

    // a game is over when all fields are taken
    // a game is over when all fields in a column are taken by a player
    // a game is over when all fields in a row are taken by a player
    // a game is over when all fields in a diagonal are taken by a player

    private final StoryBoard storyBoard = new StoryBoard();
    private final TicTacToe ticTacToe = new TicTacToe();

    @Test
    void tieGame() {
        storyBoard.addDescription("Tic-Tac-Toe: Tie Game");
        storyBoard.addFrame("New Game", ticTacToe);

        playerXTakes('5');
        playerOTakes('6');
        playerXTakes('2');
        playerOTakes('8');
        playerXTakes('9');
        playerOTakes('1');
        playerXTakes('3');
        playerOTakes('7');
        playerXTakes('4');

        Approvals.verify(storyBoard);
    }

    @Test
    void playerXWins() {
        storyBoard.addDescription("Tic-Tac-Toe: Player X Wins");
        storyBoard.addFrame("New Game", ticTacToe);

        playerXTakes('1');
        playerOTakes('7');
        playerXTakes('2');
        playerOTakes('9');
        playerXTakes('3');
        playerOFailsToTake('8');

        Approvals.verify(storyBoard);
    }

    @Test
    void illegalLocation() {
        assertThatThrownBy(()-> ticTacToe.take('A'))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid location: A");
    }

    @Test
    void illegalMove() {
        ticTacToe.take('5');
        assertIllegalMove(() -> ticTacToe.take('5'),
                "The square at location 5 has already been taken.");
    }

    private void assertIllegalMove(ThrowableAssert.ThrowingCallable lambda, String message) {
        assertThatThrownBy(lambda)
                .isInstanceOf(SquareAlreadyTakenException.class)
                        .hasMessage(message);
    }

    private void playerXTakes(char location) {
        ticTacToe.take(location);
        storyBoard.addFrame("Player X takes " + location, ticTacToe);
    }

    private void playerOTakes(char location) {
        ticTacToe.take(location);
        storyBoard.addFrame("Player O takes " + location, ticTacToe);
    }

    private void playerOFailsToTake(char location) {
        ticTacToe.take(location);
        storyBoard.addFrame("Player O fails to take " + location, ticTacToe);
    }
}
