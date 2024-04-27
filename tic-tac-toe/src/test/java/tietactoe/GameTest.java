package tietactoe;

import org.approvaltests.Approvals;
import org.approvaltests.StoryBoard;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(QuietReporter.class)
class GameTest {

    @Test
    void ticTacToeGame() {
        StoryBoard storyBoard = new StoryBoard();
        storyBoard.addDescription("Tic-Tac-Toe");

        TicTacToe ticTacToe = new TicTacToe();
        storyBoard.addFrame("New Game", ticTacToe);

        ticTacToe.place("X", new Coordinate(1, 1));
        storyBoard.addFrame("Player X takes turn", ticTacToe);

        ticTacToe.place("Y", new Coordinate(1, 1));
        storyBoard.addFrame("Player Y makes illegal move", ticTacToe);

        Approvals.verify(storyBoard);
    }
}
