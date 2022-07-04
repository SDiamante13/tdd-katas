package tech.pathtoprogramming;

class Property {

    private final String name;
    private final int price;

    public Property(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int price() {
        return this.price;
    }
}
