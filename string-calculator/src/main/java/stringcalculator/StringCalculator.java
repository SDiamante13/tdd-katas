package stringcalculator;

import static java.util.Arrays.stream;

class StringCalculator {

    public String add(String numbers) {
        if (numbers.isEmpty()) {
            return "0";
        }
        if (numbers.length() == 1) {
            return numbers;
        }
        return calculateSumOf(numbers);
    }

    private String calculateSumOf(String numbers) {
        var sum = stream(numbers.split("[,|\\n]"))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        return String.valueOf(sum);
    }

}
