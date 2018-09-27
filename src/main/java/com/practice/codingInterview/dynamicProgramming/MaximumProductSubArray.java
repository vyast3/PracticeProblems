package com.practice.codingInterview.dynamicProgramming;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 * Created by vyast3 on 4/22/16.
 */
public class MaximumProductSubArray {

    public static void main(String[] args) {

        int a[] = {2, 3, -2, -4};
        System.out.println(findProdContiguous(a));
    }

    /*
    This is similar to maximum subarray. Instead of sum, the sign of number affect the product value.
    When iterating the array, each element has two possibilities: positive number or negative number.
    We need to track a minimum value, so that when a negative number is given, it can also find the maximum value.
    We define two local variables, one tracks the maximum and the other tracks the minimum.
     */
    public static int findProdContiguous(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int maxEndingHere = array[0], minEndingHere = array[0], maxSoFar = array[0];
        for (int i = 1; i < array.length; i++) {
            int temp = maxEndingHere;
            maxEndingHere = Math.max(Math.max(maxEndingHere * array[i], minEndingHere * array[i]), array[i]);
            minEndingHere = Math.min(Math.min(temp * array[i], minEndingHere * array[i]), array[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
