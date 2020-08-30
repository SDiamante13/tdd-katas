package tech.pathtoprogramming.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void shuffle() {
        int[] result = solution.shuffle(new int[]{2,5,1,3,4,7}, 3);

        assertThat(result).containsSequence(2,3,5,4,1,7);
    }


    @Test
    void finalPrices() {
        int[] result = solution.finalPrices(new int[]{8,4,6,2,3});

        assertThat(result).containsSequence(4,2,4,2,3);
    }

    @Test
    void finalPricesCanCommuteZeroAsFinalPrice() {
        int[] result = solution.finalPrices(new int[]{10,1,1,6});

        assertThat(result).containsSequence(9,0,1,6);
    }

    @Test
    void isPathCrossing() {
        String input = "WSSESEEE";
        assertThat(solution.isPathCrossing(input)).isFalse();
    }

    @Test
    void isPathCrossingB() {
        String input = "SN";
        assertThat(solution.isPathCrossing(input)).isTrue();
    }

    @Test
    void isPathCrossingIsTrue() {
        String input = "NESWW";
        assertThat(solution.isPathCrossing(input)).isTrue();
    }


    @ParameterizedTest
    @CsvSource(value = {"1,4,2", "3,7,1", "0,0,0", "10,14,1", "19,47,4"})
    void hammingDistance(int num1, int num2, int expected) {
        int result = solution.hammingDistance(num1, num2);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5,2", "8,3", "15,5", "0,0", "2147483647,65535"})
    void arrangeCoins(int noOfCoins, int stairs) {
        int result = solution.arrangeCoins(noOfCoins);

        assertThat(result).isEqualTo(stairs);
    }

    @ParameterizedTest
    @MethodSource("plusArrays")
    void plusOne(int[] input, int[] output) {
        int[] result = solution.plusOne(input);

        assertThat(result).isEqualTo(output);
    }

    static Stream<Arguments> plusArrays() {
        return Stream.of(
                Arguments.of(new int[]{1, 1},new int[]{1, 2}),
                Arguments.of(new int[]{1, 2, 3},new int[]{1, 2, 4}),
                Arguments.of(new int[]{4, 3, 2, 1},new int[]{4,3,2,2}),
                Arguments.of(new int[]{1,9},new int[]{2,0}),
                Arguments.of(new int[]{9,9},new int[]{1,0,0}),
                Arguments.of(new int[]{7,9,9,6,5,9,9,9},new int[]{7,9,9,6,6,0,0,0})

        );
    }
}