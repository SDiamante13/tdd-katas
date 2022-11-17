package texasholdem;

class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput(System.in);
        Player player1 = new Player(userInput);
        Player player2 = new Player(userInput);
        new Game(player1, player2).deal();

        System.out.println(" Player cards: " + player1.showCards());
    }
}
