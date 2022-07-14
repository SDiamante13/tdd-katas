package tech.pathtoprogramming;

public class DiceRoll {
    private int first;
    private int second;

    public DiceRoll(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int total() {
        return first + second;
    }
}
