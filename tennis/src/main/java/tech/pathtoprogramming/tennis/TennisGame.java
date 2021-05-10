package tech.pathtoprogramming.tennis;

import java.util.HashMap;
import java.util.Map;

import static tech.pathtoprogramming.tennis.Player.PLAYER1;
import static tech.pathtoprogramming.tennis.Player.PLAYER2;

public class TennisGame {

    private int player1Points;
    private int player2Points;
    private Scoreboard scoreboard;

    public TennisGame(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;

        this.player1Points = 0;
        this.player2Points = 0;
    }

    public String getScore() {
        return scoreboard.currentScore(player1Points, player2Points);
    }

    public String score(Player playerWhoScored) {
        if (playerWhoScored.equals(PLAYER1)) {
            player1Points++;
        } else if(playerWhoScored.equals(PLAYER2)) {
            player2Points++;
        }
        return getScore();
    }
}
