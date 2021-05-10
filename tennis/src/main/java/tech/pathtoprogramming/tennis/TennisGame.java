package tech.pathtoprogramming.tennis;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    private int player1Score;
    private int player2Score;
    private Map<Integer, Integer> pointsMap;

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

    public String score(String playerWhoScored) {
        if (playerWhoScored.equals("Player 1")) {
            player1Score++;
            return getScore();
        } else
            return "0-15";
    }
}
