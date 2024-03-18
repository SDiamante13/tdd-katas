package tech.pathtoprogramming.fizzbuzz;

public class FizzBuzzChain {

    private final DivisibilityChain divisibleByFifteen;

    public FizzBuzzChain() {
        this.divisibleByFifteen = new DivisibleByFifteen();
        DivisibilityChain divisibleByFive = new DivisibleByFive();
        DivisibilityChain divisibleByThree = new DivisibleByThree();
        DivisibilityChain number = new Number();
        divisibleByFifteen.setNextChain(divisibleByFive);
        divisibleByFive.setNextChain(divisibleByThree);
        divisibleByThree.setNextChain(number);
    }

    public String getResult(int number) {
        return divisibleByFifteen.getResult(number);
    }
}

class DivisibleByFifteen implements DivisibilityChain {
    private DivisibilityChain chain;

    @Override
    public void setNextChain(DivisibilityChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getResult(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        }
        return this.chain.getResult(number);
    }
}

class DivisibleByFive implements DivisibilityChain {

    private DivisibilityChain chain;

    @Override
    public void setNextChain(DivisibilityChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getResult(int number) {
        if (number % 5 == 0) {
            return "Buzz";
        }
        return this.chain.getResult(number);
    }
}

class DivisibleByThree implements DivisibilityChain {

    private DivisibilityChain chain;

    @Override
    public void setNextChain(DivisibilityChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public String getResult(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        }
        return this.chain.getResult(number);
    }
}

class Number implements DivisibilityChain {

    private DivisibilityChain chain;

    @Override
    public void setNextChain(DivisibilityChain next) {
        this.chain = next;
    }

    @Override
    public String getResult(int number) {
        return String.valueOf(number);
    }
}


interface DivisibilityChain {
    void setNextChain(DivisibilityChain next);

    String getResult(int number);
}
