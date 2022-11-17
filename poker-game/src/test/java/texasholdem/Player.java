package texasholdem;

import java.util.ArrayList;
import java.util.List;

class Player {

    private final UserInput userInput;
    private final List<String> cards;
    // TODO: code smell primitive obsession
    private final List<String> possibleCardsList;
    // TODO: code smell primitive obsession
    private final int chips;

    Player(UserInput userInput) {
        this.userInput = userInput;
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
        return Choice.CHECK;
    }
}
