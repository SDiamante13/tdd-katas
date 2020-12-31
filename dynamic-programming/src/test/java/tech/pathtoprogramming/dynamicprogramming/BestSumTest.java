package tech.pathtoprogramming.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BestSumTest {

    @Test
    void bestSumOf7() {
        int targetSum = 7;
        int[] numbers = new int[]{5, 3, 4, 7};

        int[] result = BestSum.bestSum(targetSum, numbers, null);

        assertThat(result).contains(7);
    }

    @Test
    void bestSumOf8() {
        int targetSum = 8;
        int[] numbers = new int[]{2, 3, 5};

        int[] result = BestSum.bestSum(targetSum, numbers, null);

        assertThat(result).contains(3, 5);
    }

    @Test
    void bestSumOf100() {
        int targetSum = 100;
        int[] numbers = new int[]{1, 2, 5, 25};

        int[] result = BestSum.bestSum(targetSum, numbers, null);

        assertThat(result).contains(25, 25, 25, 25);
    }

}