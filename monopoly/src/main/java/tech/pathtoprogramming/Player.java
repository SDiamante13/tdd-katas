package tech.pathtoprogramming;

class Player {

    private int money;
    private int location;

    public Player() {
        this.money = 1500;
        this.location = 0;
    }

    public int money() {
        return money;
    }

    public int location() {
        return 3;
    }

    public void buyProperty(Property property) {
        money -= property.price();
    }
}
