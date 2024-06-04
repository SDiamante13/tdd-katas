package tech.pathtoprogramming.fizzbuzz;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FizzBuzzTest {

    @Test
    void countTo20() {
        String result = FizzBuzz.countTo(20);
        Approvals.verify(result);
    }

    private static class FizzBuzz {
        public static String countTo(int lastNumber) {
            List<String> parts = new ArrayList<>();
            for (int i = 1; i <= lastNumber; i++) {
                parts.add(calculate(i));
            }
            return String.join("\n", parts);
        }

        private static String calculate(int i) {
            if (i % 15 == 0) {
                return "FizzBuzz";
            } else if (i % 3 == 0) {
                return "Fizz";
            } else if (i % 5 == 0) {
                return "Buzz";
            }
            return String.valueOf(i);
        }
    }
}
