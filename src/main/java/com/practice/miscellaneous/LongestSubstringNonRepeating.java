package com.practice.miscellaneous;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstringNonRepeating {
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (set.add(s.charAt(j))) {
                j++;
                max = Math.max(max, set.size());
                continue;
            }
            set.remove(s.charAt(i));
            i++;
        }
        System.out.println(max);
        return max;
    }

    public static void sum(int[] a, int[] b) {

        int[] sum = new int[Math.max(a.length, b.length)];

        for (int i = 0; i < sum.length; i++) {
            sum[i] = (i < a.length ? a[i] : 0) + (i < b.length ? b[i] : 0);
        }
        for (int i = 0; i < sum.length; i++) {
            System.out.print(sum[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {9, 9, 9};
        sum(a, b);
    }
}
