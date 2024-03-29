package tech.pathtoprogramming;

public class Property {

    private final String name;
    private final int price;

    public Property(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String name() {
        return name;
    }

    public int price() {
        return this.price;
    }
}
