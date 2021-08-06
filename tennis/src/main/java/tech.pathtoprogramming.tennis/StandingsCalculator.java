package tech.pathtoprogramming.tennis;

public class StandingsCalculator {

    public String calculate(int playerAScore, int playerBScore) {
        String result;

        if (checkIfGameIsWon(playerAScore, playerBScore)) {
            result = playerAScore > playerBScore ?
                    "PlayerA won" :
                    "PlayerB won";
        } else if (checkIfScoreIsDeuce(playerAScore, playerBScore)) {
            result = "deuce";
        } else if (checkIfScoreIsAdvantage(playerAScore, playerBScore)) {
            result = playerAScore > playerBScore ?
                    "advantage PlayerA" :
                    "advantage PlayerB";
        } else {
            result = translateScore(playerAScore);
            result += ":";
            result += translateScore(playerBScore);
        }

        return result;
    }

    private boolean checkIfGameIsWon(int playerAScore, int playerBScore) {
        boolean gameWon = false;
        int pointsDifference = playerAScore - playerBScore;

        if ((playerAScore > 3 || playerBScore > 3) && Math.abs(pointsDifference) > 1) {
            gameWon = true;
        }

        return gameWon;
    }

    private boolean checkIfScoreIsDeuce(int playerAScore, int playerBScore) {
        boolean isDeuce = playerAScore >= 3 && playerBScore >= 3 && playerAScore == playerBScore;

        return isDeuce;
    }

    private boolean checkIfScoreIsAdvantage(int playerAScore, int playerBScore) {
        boolean isAdvantage = playerAScore >= 3 && playerBScore >= 3 && playerAScore != playerBScore;

        return isAdvantage;
    }

    private String translateScore(int playerScore) {
        String result = "";

        switch (playerScore) {
            case 0:
                result = "love";
                break;
            case 1:
                result = "fifteen";
                break;
            case 2:
                result = "thirty";
                break;
            case 3:
                result = "forty";
                break;
        }

        return result;
    }
}
