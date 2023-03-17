package texasholdem;

import java.util.List;

class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        new Hand(Pot.EMPTY(), player1, player2).deal();

        Game game = new Game(List.of(player1, player2).toArray(new Player[0]));
        game.start();

        System.out.println(" Player cards: " + player1.showCards());
        System.out.println(" Player chips: " + player1.chips());
        System.out.println(" Player cards: " + player2.showCards());
        System.out.println(" Player chips: " + player2.chips());
    }
}
