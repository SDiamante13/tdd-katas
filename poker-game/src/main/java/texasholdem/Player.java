package texasholdem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Hand contains players, pot
// player should have a next decision that can be faked

public class Player {

    private int chips;
    private List<Card> holeCards;

    public Player(int chips) {
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

    public Choice askForChoice() { // what depends on choice of players
        // get system in
        // F - fold
        // C - call
        // CH - check
        // R,30 - raise

        // factory method
        // based on input return a different Choice
        // whenever I remove chips from the play
        // I need to add it to the hand
        Scanner scanner = new Scanner(System.in);
        String choiceString = scanner.nextLine();
        // CH
        // C
        // R 20
        // F

        Choice choice = Choice.create(choiceString);
        switch (choice.state()) {
            case "CHECK":

                break;
        }
        return choice;
    }
}
