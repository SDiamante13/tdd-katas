package tietactoe;

import org.approvaltests.Approvals;
import org.approvaltests.StoryBoard;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(QuietReporter.class)
class TicTacToeTest {

    @Test
    void ticTacToeGame() {
        StoryBoard storyBoard = new StoryBoard();
        storyBoard.addDescription("Tic-Tac-Toe");

        TicTacToe ticTacToe = new TicTacToe();
        storyBoard.addFrame("New Game", ticTacToe);

        ticTacToe.take('5');
        storyBoard.addFrame("Player X takes turn", ticTacToe);

        ticTacToe.take('6');
        storyBoard.addFrame("Player O takes turn", ticTacToe);

        Approvals.verify(storyBoard);
    }
}