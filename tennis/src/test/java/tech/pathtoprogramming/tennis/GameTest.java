package tech.pathtoprogramming.tennis;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

class GameTest {

    private StandingsCalculator mockStandingsCalculator = Mockito.mock(StandingsCalculator.class);

    private Player mockPlayerA = Mockito.mock(Player.class);

    private Player mockPlayerB = Mockito.mock(Player.class);

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(mockStandingsCalculator, mockPlayerA, mockPlayerB);
    }

    @Test
    void score_callsStandingsCalculateForTheCurrentScore() {
        game.score();

        Mockito.verify(mockPlayerA).getScore();
        Mockito.verify(mockPlayerB).getScore();
        Mockito.verify(mockStandingsCalculator).calculate(anyInt(), anyInt());
    }

    @Test
    void playPoint_GivesAPlayerAPoint() {
        game.playPoint(mockPlayerA);

        Mockito.verify(mockPlayerA).winPoint();
        Mockito.verifyNoInteractions(mockPlayerB);
    }
}