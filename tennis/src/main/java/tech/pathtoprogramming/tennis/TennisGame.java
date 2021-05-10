package tech.pathtoprogramming.tennis;

public class TennisGame {

    private int player1Score;
    private int player2Score;

    public TennisGame() {
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public String getScore() {
        return player1Score + "-" + player2Score;
    }

    public String score(String playerWhoScored) {
        if (playerWhoScored.equals("Player 1")) {
          player1Score += 15;
          return getScore();
        } else
            return "0-15";
    }
}
