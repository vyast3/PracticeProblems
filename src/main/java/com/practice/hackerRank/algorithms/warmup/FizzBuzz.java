package com.practice.hackerRank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vyast3 on 1/25/15.
 */
public class FizzBuzz {
    public static void main(String[] args) {
        List<String> sample = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        for(int i=1;i<=n;i++){
            if((i%3 == 0) && (i%5==0))
                System.out.println("FizzBuzz");
            else if(i%3 == 0)
                System.out.println("Fizz");
            else if(i%5 == 0)
                System.out.println("Buzz");
           /* else
                System.out.println(i);*/
        }
    }
}
