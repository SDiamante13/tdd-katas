package tech.pathtoprogramming.tennis;

import java.util.HashMap;
import java.util.Map;

import static tech.pathtoprogramming.tennis.Player.PLAYER1;
import static tech.pathtoprogramming.tennis.Player.PLAYER2;

public class TennisGame {

    private int player1Score;
    private int player2Score;
    private final Map<Integer, Integer> pointsMap;

    public TennisGame() {
        this.player1Score = 0;
        this.player2Score = 0;
        pointsMap = new HashMap<>();
        pointsMap.put(0, 0);
        pointsMap.put(1, 15);
        pointsMap.put(2, 30);
        pointsMap.put(3, 40);
    }

    public String getScore() {
        return pointsMap.get(player1Score) + "-" + pointsMap.get(player2Score);
    }

    public String score(Player playerWhoScored) {
        if (playerWhoScored.equals(PLAYER1)) {
            player1Score++;
        } else if(playerWhoScored.equals(PLAYER2)) {
            player2Score++;
        }
        return getScore();
    }
}
