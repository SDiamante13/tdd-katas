package tech.pathtoprogramming.tennis;

public class Game {

    private final StandingsCalculator standingsCalculator;
    private final Player playerA;
    private final Player playerB;

    public Game(StandingsCalculator standingsCalculator, Player playerA, Player playerB) {
        this.standingsCalculator = standingsCalculator;
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public String score() {
        return standingsCalculator.calculate(playerA.getScore(), playerB.getScore());
    }

    public void playPoint(Player playerWinsPoint) {
        playerWinsPoint.winPoint();
    }
}
