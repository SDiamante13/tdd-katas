package tech.pathtoprogramming.dynamicprogramming;

import java.util.HashMap;

public class WordUtils {

    public static boolean canConstruct(String target, String[] wordBank, HashMap<String, Boolean> memo) {
        if (memo == null) memo = new HashMap<>();
        if (memo.containsKey(target)) return memo.get(target);

        if (target.equals("")) return true;

        for (String selection : wordBank) {
            if (target.startsWith(selection) && canConstruct(target.substring(selection.length()), wordBank, memo)) {
                memo.put(target, true);
                return true;
            }
        }

        memo.put(target, false);
        return false;
    }

    public static int countConstruct(String target, String[] wordBank, HashMap<String, Integer> memo) {
        if (memo == null) memo = new HashMap<>();
        if (memo.containsKey(target)) return memo.get(target);

        int totalCount = 0;
        if (target.equals("")) return 1;

        for (String word: wordBank) {
            if (target.startsWith(word)) {
                int numberOfWaysForRest = countConstruct(target.substring(word.length()), wordBank, memo);
                memo.put(target, numberOfWaysForRest);
                totalCount += numberOfWaysForRest;
            }
        }
        return totalCount;
    }
}
