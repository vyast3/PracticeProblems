package com.practice.companies.cruiseautomation;

public class LongestSubArrayWithSumLessThanK {
    public static int maxLength(int[] arr, int k) {
        int subArraySum = 0;
        int maxLength = -1;
        int subArrayStartIndex = 0;
        int subArrayEndIndex = 0;
        for (int a : arr) {
            subArraySum += a;
            subArrayEndIndex++;
            while (subArraySum > k) {
                subArraySum -= arr[subArrayStartIndex];
                subArrayStartIndex++;
            }
            maxLength = Math.max(maxLength, subArrayEndIndex - subArrayStartIndex);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(maxLength(arr, 4));
        int[] arr2 = {3,1,2,1};
        System.out.println(maxLength(arr2, 4));

    }
}
