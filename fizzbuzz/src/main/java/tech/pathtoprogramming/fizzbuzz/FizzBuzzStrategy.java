package tech.pathtoprogramming.fizzbuzz;

public enum FizzBuzzStrategy {
    DIVISIBLE_BY_15("FizzBuzz", 15),
    DIVISIBLE_BY_5("Buzz", 5),
    DIVISIBLE_BY_3("Fizz", 3);

    private final String result;
    private final int divisor;

    FizzBuzzStrategy(String result, int divisor) {
        this.result = result;
        this.divisor = divisor;
    }

    public boolean isSatisfied(int input) {
        return input % this.divisor == 0;
    }

    public String result() {
        return this.result;
    }
}
