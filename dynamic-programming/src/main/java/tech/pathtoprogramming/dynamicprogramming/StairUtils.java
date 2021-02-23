package tech.pathtoprogramming.dynamicprogramming;

import java.util.HashMap;


public class StairUtils {

    public int climbStairs(int n) {
        return climbStairs(n, null);
    }

    public int climbStairs(int n, HashMap<Integer, Integer> memo) {
        if (memo == null) {
            memo = new HashMap<>();
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n == 1 || n == 0) {
            return 1;
        }

        int count = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        memo.put(n, count);
        return count;
    }
}
