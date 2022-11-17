package texasholdem;

class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        new Game(new Pot(), player1, player2).deal();

        System.out.println(" Player cards: " + player1.showCards());
    }
}
