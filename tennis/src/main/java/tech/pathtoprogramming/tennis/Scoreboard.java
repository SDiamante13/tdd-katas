package tech.pathtoprogramming.tennis;

public class Scoreboard {
    private final PointConverter pointConverter;

    public Scoreboard(PointConverter pointConverter) {
        this.pointConverter = pointConverter;
    }

    public String currentScore(int player1Points, int player2Points) {
        String player1Score = pointConverter.convertPointsToScore(player1Points);
        String player2Score = pointConverter.convertPointsToScore(player2Points);

        if (player1Score.equals("Winner")) {
            return "Player 1 Wins!";
        }

        if (player2Score.equals("Winner")) {
            return "Player 2 Wins!";
        }

        return player1Score + "-" + player2Score;
    }
}
