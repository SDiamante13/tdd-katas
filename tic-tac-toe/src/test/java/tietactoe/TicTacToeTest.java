package tietactoe;

import org.approvaltests.Approvals;
import org.approvaltests.StoryBoard;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(QuietReporter.class)
class TicTacToeTest {

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

    private void playerXTakes(char location) {
        ticTacToe.take(location);
        storyBoard.addFrame("Player X takes " + location, ticTacToe);
    }

    private void playerOTakes(char location) {
        ticTacToe.take(location);
        storyBoard.addFrame("Player O takes " + location, ticTacToe);
    }
}
