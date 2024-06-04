/*package tech.pathtoprogramming.fizzbuzz;

public class FizzBuzz {

    public String calculate(int number) {
        // enum FizzBuzz Chain?
//        for (FizzBuzzStrategy strategy : FizzBuzzStrategy.values()) {
//            if (strategy.isSatisfied(number)) {
//                return strategy.result();
//            }
//        }
//        return String.valueOf(number);
        return new FizzBuzzChain().getResult(number);
    }
}*/
