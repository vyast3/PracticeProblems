package com.practice.miscellaneous;

import java.util.*;

class Pascaltriangle {

    public static List<Integer> pascalTrinagle(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);

        if (numRows == 0) return null;
        result.add(arr);

        for (int i = 1; i < numRows; i++) {

            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);

            for (int j = 0; j + 1 < result.size(); j++) {
                int val = result.get(result.size() - 1).get(j) + result.get(result.size() - 1).get(j + 1);
                temp.add(val);
            }
            temp.add(1);
            result.add(temp);
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        return result.get(result.size() - 1);
    }

    public static void main(String[] args) {
        List<Integer> results = pascalTrinagle(4);

        for (Integer result : results) {
            System.out.print(result);
        }
    }
}