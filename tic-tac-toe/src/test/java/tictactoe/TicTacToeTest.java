package tictactoe;

import org.approvaltests.Approvals;
import org.approvaltests.StoryBoard;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@UseReporter(QuietReporter.class)
class TicTacToeTest {

    private final StoryBoard storyBoard = new StoryBoard();
    private TicTacToe ticTacToe;

    @Test
    void tieGame() {
        storyBoard.addDescription("Tic-Tac-Toe: Tie Game");

        newGame();

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
        storyBoard.addDescription("Tic-Tac-Toe: Player X Wins on Top Horizontal");
        newGame();

        playerXTakes('1');
        playerOTakes('7');
        playerXTakes('2');
        playerOTakes('9');
        playerXTakes('3');
        playerOFailsToTake('8');

        Approvals.verify(storyBoard);
    }

    @Test
    void playerOWinsHorizontallyBottom() {
        storyBoard.addDescription("Tic-Tac-Toe: Player O Wins Horizontally Bottom");
        newGame();

        playerXTakes('1');
        playerOTakes('7');
        playerXTakes('2');
        playerOTakes('9');
        playerXTakes('5');
        playerOTakes('8');

        Approvals.verify(storyBoard);
    }

    @Test
    void playerOWinsHorizontallyCenter() {
        storyBoard.addDescription("Tic-Tac-Toe: Player O Wins Center Horizontally");
        newGame();

        playerXTakes('1');
        playerOTakes('4');
        playerXTakes('2');
        playerOTakes('5');
        playerXTakes('9');
        playerOTakes('6');

        Approvals.verify(storyBoard);
    }

    @Test
    void playerXWinsVertically() {
        storyBoard.addDescription("Tic-Tac-Toe: Player X Wins on Left Vertically");
        newGame();

        playerXTakes('1');
        playerOTakes('8');
        playerXTakes('4');
        playerOTakes('9');
        playerXTakes('7');

        Approvals.verify(storyBoard);
    }

    @Test
    void playerXWinsCenterVertically() {
        storyBoard.addDescription("Tic-Tac-Toe: Player X Wins on Center Vertically");
        newGame();

        playerXTakes('2');
        playerOTakes('7');
        playerXTakes('5');
        playerOTakes('9');
        playerXTakes('8');

        Approvals.verify(storyBoard);
    }

    @Test
    void playerXWinsRightVertically() {
        storyBoard.addDescription("Tic-Tac-Toe: Player X Wins on Right Vertically");
        newGame();

        playerXTakes('3');
        playerOTakes('1');
        playerXTakes('6');
        playerOTakes('8');
        playerXTakes('9');

        Approvals.verify(storyBoard);
    }

    @Test
    void playerOWinsRightDiagonally() {
        storyBoard.addDescription("Tic-Tac-Toe: Player O Wins on Right Diagonally");
        newGame();

        playerXTakes('3');
        playerOTakes('1');
        playerXTakes('7');
        playerOTakes('5');
        playerXTakes('8');
        playerOTakes('9');

        Approvals.verify(storyBoard);
    }

    @Test
    void playerOWinsLeftDiagonally() {
        storyBoard.addDescription("Tic-Tac-Toe: Player O Wins on Left Diagonally");
        newGame();

        playerXTakes('1');
        playerOTakes('3');
        playerXTakes('2');
        playerOTakes('5');
        playerXTakes('8');
        playerOTakes('7');

        Approvals.verify(storyBoard);
    }

    @Test
    void illegalLocation() {
        ticTacToe = new TicTacToe("Paul", "Lisa");
        assertThatThrownBy(()-> ticTacToe.take('A'))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid location: A");
    }

    @Test
    void illegalMove() {
        ticTacToe = new TicTacToe("Paul", "Lisa");
        ticTacToe.take('5');
        assertIllegalMove(() -> ticTacToe.take('5'),
                "The square at location 5 has already been taken.");
    }

    private void assertIllegalMove(ThrowableAssert.ThrowingCallable lambda, String message) {
        assertThatThrownBy(lambda)
                .isInstanceOf(SquareAlreadyTakenException.class)
                        .hasMessage(message);
    }

    private void newGame() {
        ticTacToe = new TicTacToe("Paul", "Lisa");
        storyBoard.addFrame("New Game", ticTacToe);
        storyBoard.addFrame("Players", ticTacToe.printPlayers());
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
