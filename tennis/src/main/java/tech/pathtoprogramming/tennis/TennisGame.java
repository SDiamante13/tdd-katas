package tech.pathtoprogramming.tennis;

public class TennisGame {

    public String getScore() {
        return "0-0";
    }

    public String score(String playerWhoScored) {
        if (playerWhoScored.equals("Player 1"))
            return "15-0";
        else
            return "0-15";
    }
}
