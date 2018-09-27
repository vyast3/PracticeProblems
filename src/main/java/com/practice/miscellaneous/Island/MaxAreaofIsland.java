package com.practice.miscellaneous.Island;

/**
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class MaxAreaofIsland {
    public static void main(String[] args) {
        int grid[][] = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxSize(grid));

    }

    private static int maxSize(int[][] grid) {
        int maxSize = 0;
        if (grid == null || grid.length == 0) {
            return maxSize;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int size = dfs(grid, r, c, visited);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    private static int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }
        int size = 1;
        visited[r][c] = true;
        size += dfs(grid, r - 1, c, visited) + dfs(grid, r + 1, c, visited) + dfs(grid, r, c - 1, visited) + dfs(grid, r, c + 1, visited);
        return size;
    }

}
