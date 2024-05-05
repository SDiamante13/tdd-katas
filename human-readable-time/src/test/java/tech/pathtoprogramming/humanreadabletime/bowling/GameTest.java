package tech.pathtoprogramming.humanreadabletime.bowling;

import org.approvaltests.Approvals;
import org.approvaltests.core.Options;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void fullGame() {
        Game game = new Game();
        GamePrinter gamePrinter = new GamePrinter(game);

        Approvals.verify(gamePrinter.print(),
                new Options().forFile().withExtension(".md"));
    }
}
