package com.practice.miscellaneous;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/description/
 */
public class WordLadder {
    class WordNode {
        String word;
        int numSteps;

        public WordNode(String word, int numSteps) {
            this.word = word;
            this.numSteps = numSteps;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordDict = new HashSet<String>(wordList);
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;
            int numSteps = top.numSteps;
            if (word.equals(endWord)) {
                return numSteps;
            }

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    arr[i] = c;
                    String newWord = new String(arr);
                    if (wordDict.contains(newWord)) {
                        wordDict.remove(newWord);
                        queue.add(new WordNode(newWord, numSteps + 1));
                    }
                    arr[i]=temp;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}
