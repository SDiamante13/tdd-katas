package tech.pathtoprogramming.tennis;

public class MainApplication {
    public static void main(String[] args) {
        StandingsCalculator standingsCalculator = new StandingsCalculator();
        Player playerA = new Player();
        Player playerB = new Player();

        Game game = new Game(standingsCalculator, playerA, playerB);

        System.out.println("Initial Score: " + game.score());

        game.playPoint(playerA);
        System.out.println("Player A Scored, current score: " + game.score());

        game.playPoint(playerB);
        System.out.println("Player B Scored, current score: " + game.score());

        game.playPoint(playerB);
        System.out.println("Player B Scored, current score: " + game.score());

        game.playPoint(playerA);
        System.out.println("Player A Scored, current score: " + game.score());

        game.playPoint(playerB);
        System.out.println("Player B Scored, current score: " + game.score());

        game.playPoint(playerB);
        System.out.println("Player B Scored, current score: " + game.score());

    }
}
