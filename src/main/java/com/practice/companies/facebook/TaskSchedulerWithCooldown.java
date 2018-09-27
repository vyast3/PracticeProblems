package com.practice.companies.facebook;

import java.util.*;

/**
 * Given a list of input tasks to run, and the cooldown interval, output the minimum number of time slots required to run them.
 * // Tasks: 1, 1, 2, 1, 2
 * // Recovery interval (cooldown): 2
 * // Output: 8 (order is 1 _ _ 1 2 _ 1 2 )
 *
 * =========
 * Tasks are task numbers in that order coming in for execution. Cooling time is time interval required to cool down the machine after executing a task. So it's like if CPU executed task 1 then it needs 2 cooling time intervals before executing another task 1 but meanwhile, it can execute other tasks which are not same as 1 and so on. So before executing any task, you have to check if you have executed same task number before and if yes, then if its cooling time interval is done or not.
 * The output is basically the number of cycles/time slots CPU took to execute these tasks in that order (including when task executed and cooling intervals).
 */
public class TaskSchedulerWithCooldown {
    public static int leastInterval(int[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int slots = 0;

        for (int task : tasks) {
            if (map.containsKey(task) && map.get(task) > slots) {
                slots = map.get(task);

            } else {
                slots++;
            }
            map.put(task, slots + 1 + n);

        }

        return slots;
    }

    public static int timeSlots(int[] tasks, int cooldown) {
        if (cooldown <= 0) {
            return tasks.length;
        }

        Map<Integer, Integer> lastTimeSlot = new HashMap<>();
        int result = 0;
        int taskIndex = 0;

        while (taskIndex < tasks.length) {
            Integer task = tasks[taskIndex];
            Integer last = lastTimeSlot.get(task);
            if (last == null || result - last > cooldown) {
                lastTimeSlot.put(task, result);
                taskIndex++;
            }
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] tasks = {1, 1, 2, 1, 2};
        System.out.println(leastInterval(tasks, 2));
    }
}
