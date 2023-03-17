package texasholdem;

class Game {

    private Player[] players;
    private Hand currentHand;

    public Game(Player[] players) {
        this.players = players;
    }

    // hands change the state of players
    // games have many hands

    public void start() {
        // currentHand.playWith(players);
        currentHand = new Hand(Pot.EMPTY(), players);
        // game starts by dealing players cards
        playWith(currentHand);
    }

    private void playWith(Hand currentHand) {
        currentHand.deal();
        // players bet on the strength of 2 cards
        currentHand.bet();
        //players should be object so you can get chips easily
        // deal the flop
        currentHand.flop();
        System.out.println("Community Cards: " + currentHand.communityCards());
        currentHand.bet();
    }
}
