package texasholdem;

import java.util.ArrayList;
import java.util.List;

public class ActivePlayer implements Player {

    private int chips;
    private List<Card> holeCards;

    public ActivePlayer(int chips) {
        this.chips = chips;
        this.holeCards = new ArrayList<>();
    }

    public int chips() {
        return this.chips;
    }

    public void bet(int chips) {
        this.chips -= chips;
    }

    public void receiveHoleCards(Card card) {
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
    public Choice choice() {
        // get system in
        // F - fold
        // C - call
        // CH - check
        // R,30 - raise

        // factory method
        // based on input return a different Choice
        return Choice.CHECK;
    }
}
