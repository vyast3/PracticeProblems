package com.practice.companies.facebook;

/**
 * Push all the zero's of a given array to the end of the array.
 * In place only. Ex 1,2,0,4,0,0,8 becomes 1,2,4,8,0,0,0
 * <p>
 * https://www.careercup.com/question?id=12986664
 * <p>
 * Created by vyast3 on 4/24/16.
 */
public class MoveZerosToEnd {
    public static void main(String[] args) {

        int arr[] = {1, 2, 0, 4, 0, 0, 8};
        System.out.print("Input = ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        convert(arr);
        System.out.println();
        System.out.print("Output = ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }

    public static void convert(int[] a) {
        int zCount = 0;
        int j = 0;
        int i = 0;
        while (i < a.length && j < a.length) {
            if(a[j] != 0){
                a[i] = a[j];
                i++;j++;
            }else{
                zCount++;
                j++;
            }
        }

        while (zCount > 0) {
            a[i++] = 0;
            zCount--;
        }


    }
}
