package tech.pathtoprogramming.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestSum {

    public static int[] bestSum(int targetSum, int[] numbers, Map<Integer, int[]> memo) {
        if (memo == null) {
            memo = new HashMap<>();
        }
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new int[]{};
        if (targetSum < 0) return null;

        int[] shortestCombination = null;

        for (int num : numbers) {
            int remainder = targetSum - num;
            int[] remainderResult = bestSum(remainder, numbers, memo);
            if (remainderResult != null) {
                int[] combination = Arrays.copyOf(remainderResult, remainderResult.length + 1);
                combination[combination.length-1] = num;
                if (shortestCombination == null || combination.length < shortestCombination.length) {
                    shortestCombination = combination;
                }
            }

        }
        memo.put(targetSum, shortestCombination);
        return shortestCombination;
    }
}
