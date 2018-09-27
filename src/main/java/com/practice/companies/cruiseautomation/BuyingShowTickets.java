package com.practice.companies.cruiseautomation;

public class BuyingShowTickets {
    public static int waitingTimes(int[] tickets, int p) {
        int len = tickets.length;
        if (p >= len) {
            return -1;
        }
        int totalSteps = tickets[p];

        int[] firstHalf = new int[p];
        System.arraycopy(tickets, 0, firstHalf, 0, firstHalf.length);
        for (int num : firstHalf) {
            if (num < tickets[p]) {
                totalSteps += num;
            } else {
                totalSteps += tickets[p];
            }
        }
        if (p < len - 1) {
            int[] secondHalf = new int[len - p - 1];
            System.arraycopy(tickets, p + 1, secondHalf, 0, secondHalf.length);
            for (int num : secondHalf) {
                if (num < tickets[p]) {
                    totalSteps += num;
                } else {
                    totalSteps += tickets[p] - 1;

                }
            }
        }
        return totalSteps;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 3, 4, 5};
        int[] arr2 = {5, 5, 2, 3};
        int[] arr3 = {1, 1, 1, 1};

        System.out.println(waitingTimes(arr2, 3));
        System.out.println(waitingTimes(arr2, 0));
        System.out.println(waitingTimes(arr2, 1));
        System.out.println(waitingTimes(arr2, 2));
        System.out.println(waitingTimes(arr3, 0));
        System.out.println(waitingTimes(arr, 2));
        System.out.println(waitingTimes(arr, 0));
        System.out.println(waitingTimes(arr, 1));
        System.out.println(waitingTimes(arr, 3));
        System.out.println(waitingTimes(arr, 4));
    }

}
