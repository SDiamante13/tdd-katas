package tech.pathtoprogramming.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DivisorGame {
    // leetcode 1025
    // easy solution is return N % 2 == 0
    public boolean divisorGame(int N) {
        return divisorGame(N, null);
    }

    public boolean divisorGame(int N, HashMap<Integer, Boolean> memo) {
        if (memo == null) {
            memo = new HashMap<>();
        }
        if (memo.containsKey(N)) {
            return memo.get(N);
        }
        if (N == 1) {
            return false;
        }

        List<Integer> possibleXChoices = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            if (N % i == 0) {
                possibleXChoices.add(i);
            }
        }

        for (Integer x : possibleXChoices) {
            if (!divisorGame(N - x, memo)) {
                memo.put(N, true);
                return true;
            }
        }

        return false;
    }
}
