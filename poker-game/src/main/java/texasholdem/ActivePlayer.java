package texasholdem;

import java.util.ArrayList;
import java.util.List;

// Hand contains players, pot
// player should have a next decision that can be faked

public class ActivePlayer implements Player {

    private int chips;
    private List<Card> holeCards;

    public ActivePlayer(int chips) {
        this.chips = chips;
        this.holeCards = new ArrayList<>();
    }

    public int currentChips() {
        return this.chips;
    }

    public void bet(int chips) {
        this.chips -= chips;
    }

    public void take(Card card) {
        this.holeCards.add(card);
    }

    public List<Card> holeCards() {
        return this.holeCards;
    }

    public void fold() {
        this.holeCards = new ArrayList<>();
    }

    public void win(Pot pot) {
        this.chips += pot.chips();
        this.holeCards = new ArrayList<>();
    }

    @Override
    public Choice choice() { // what depends on choice of players
        // get system in
        // F - fold
        // C - call
        // CH - check
        // R,30 - raise

        // factory method
        // based on input return a different Choice
        // whenever I remove chips from the play
        // I need to add it to the hand



        return Choice.CHECK;
    }
}
