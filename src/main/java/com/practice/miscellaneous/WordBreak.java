package com.practice.miscellaneous;

import java.util.*;

public class WordBreak {
    Set<String> visited = new HashSet();
    Map<String, List<String>> visitedMap = new HashMap<>();

    public boolean wordBreak1(String s, List<String> wordDict) {
        if (visited.contains(s)) return true;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                int len = word.length();
                // base condition
                if (s.length() == len)
                    return true;
                // recursive condition
                if (wordBreak1(s.substring(len), wordDict)) {
                    visited.add(s);
                    return true;
                }
            }
        }

        return false;
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        if (visitedMap.containsKey(s)) return visitedMap.get(s);

        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = wordBreak2(s.substring(word.length()), wordDict);
                for (String sub : sublist) {
                    String temp = word + " " + sub;
                    res.add(temp.trim());
                }
            }
        }
        visitedMap.put(s, res);
        return res;
    }


    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(new WordBreak().wordBreak2("catsanddog", wordDict));
    }

}
