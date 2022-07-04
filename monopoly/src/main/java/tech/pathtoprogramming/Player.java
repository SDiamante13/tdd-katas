package tech.pathtoprogramming;

import java.util.HashSet;
import java.util.Set;

class Player {

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
}
