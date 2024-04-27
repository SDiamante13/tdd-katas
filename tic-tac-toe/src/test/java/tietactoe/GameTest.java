package tietactoe;

import org.approvaltests.Approvals;
import org.approvaltests.StoryBoard;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(QuietReporter.class)
class GameTest {

    @Test
    void storyboard() {
        StoryBoard storyBoard = new StoryBoard();
        storyBoard.addDescription("Tic-Tac-Toe");
        TicTacToe ticTacToe = new TicTacToe();
        storyBoard.addFrame("New Game", ticTacToe);
        ticTacToe.grid.place("X", new Coordinate(1, 1));
        storyBoard.addFrame("Player X takes turn", ticTacToe);

        Approvals.verify(storyBoard);
    }

}
