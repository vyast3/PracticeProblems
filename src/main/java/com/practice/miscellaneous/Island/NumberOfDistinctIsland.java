package com.practice.miscellaneous.Island;

import java.util.*;

public class NumberOfDistinctIsland {
    public static int count(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int m = grid.length, n = grid[0].length;
        Set<String> res = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<String> set = new HashSet<>();
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, i, j, set);
                    res.add(set.toString());
                }
            }
        }
        return res.size();
    }

    public static void dfs(int[][] grid, int i, int j, int baseX, int baseY, Set<String> set) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;
        set.add((i - baseX) + "_" + (j - baseY));
        grid[i][j] = 0;
        dfs(grid, i + 1, j, baseX, baseY, set);
        dfs(grid, i - 1, j, baseX, baseY, set);
        dfs(grid, i, j - 1, baseX, baseY, set);
        dfs(grid, i, j + 1, baseX, baseY, set);

    }

    public static void main(String[] args) {
        int[][] maze = {{0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1}};
        int[][] maze2 = {{1, 1, 0, 1, 1},
                         {1, 0, 0, 0, 0},
                         {0, 0, 0, 0, 1},
                         {1, 1, 0, 1, 1},
                };
      //  System.out.println(count(maze));
        System.out.println(count(maze2));
    }
}
