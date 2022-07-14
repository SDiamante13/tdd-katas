package tech.pathtoprogramming;

import java.util.HashSet;
import java.util.Set;

class Player {

    public static final int NUMBER_OF_SPACES_ON_THE_BOARD = 40;
    private int location;
    private int money;
    private Set<Property> properties;

    public Player() {
        this.location = 0;
        this.money = 1500;
        this.properties = new HashSet<>();
    }

    public int location() {
        return this.location;
    }

    public void moveTo(int newLocation) {
        this.location = newLocation;
    }

    public int money() {
        return this.money;
    }

    public Set<Property> properties() {
        return this.properties;
    }

    public void buy(Property property) {
        properties.add(property);
        money -= property.price();
    }

    public void moveSpaces(int numberOfSpaces) {
        this.location = (this.location + numberOfSpaces) % NUMBER_OF_SPACES_ON_THE_BOARD;
    }
}
