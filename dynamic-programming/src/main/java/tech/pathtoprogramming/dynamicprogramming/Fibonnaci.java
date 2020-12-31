package tech.pathtoprogramming.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonnaci {
    public static long fib(int n, Map<Integer, Long> memo) {
       if (memo == null) {
           memo = new HashMap<>();
       }
       if (memo.containsKey(n)) return memo.get(n);
       if (n <= 2) return 1;

       memo.put(n, fib(n-1, memo) + fib(n-2, memo));
       return memo.get(n);
    }
}