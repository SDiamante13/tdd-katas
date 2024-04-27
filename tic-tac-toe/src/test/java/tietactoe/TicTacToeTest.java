package tietactoe;

import org.approvaltests.Approvals;
import org.approvaltests.StoryBoard;
import org.approvaltests.reporters.QuietReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.jupiter.api.Test;

@UseReporter(QuietReporter.class)
class TicTacToeTest {

    // a game is over when all fields are taken
    // a game is over when all fields in a column are taken by a player
    // a game is over when all fields in a row are taken by a player
    // a game is over when all fields in a diagonal are taken by a player
    // a player can take a field if not already taken
    // players take turns taking fields until the game is over
    // there are two player in the game (X and O)

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
