package texasholdem;

import java.util.ArrayList;
import java.util.List;

class Player {

    private final UserInput userInput;

    // TODO: separate state data from UserInput
    private final List<String> cards;
    // TODO: code smell primitive obsession
    private final List<String> possibleCardsList;
    // TODO: code smell primitive obsession
    private int chips;
    private boolean didFold; // this is bad,
    // a player should not be tied to a Hand,
    // they should exist in a game

    Player() {
        this.userInput = new UserInput(System.in);
        this.cards = new ArrayList<>();
        // TODO: move to Cards
        this.possibleCardsList = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
        this.chips = 100;
    }

    public int numberOfCards() {
        return cards.size();
    }

    public void addCard() {
        cards.add(possibleCardsList.get(getRandomInteger(0, 13)));
    }

    public int getRandomInteger(int maximum, int minimum) {
        return ((int) (Math.random() * (maximum - minimum))) + minimum;
    }

    public String showCards() {
        return cards.toString();
    }

    public int chips() {
        return chips;
    }

    public Choice makeChoice() {
        String choice = userInput.read();
        if (choice.equals("C")) {
            return new Choice("C");
        }
        return new Choice("B", Integer.parseInt(choice.split("B")[1])); // B50
    }

    public void bet(int amount) {
        chips -= amount;
    }

    public boolean didNotFold() {
        return !didFold;
    }

    public void fold() {
        didFold = true;
    }

    public void win(Pot pot) {
        this.chips += pot.amount();
    }
}
