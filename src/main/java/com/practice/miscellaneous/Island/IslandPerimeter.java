package com.practice.miscellaneous.Island;

/**
 * https://leetcode.com/problems/island-perimeter/description/
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0},
        };
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        if (grid == null || grid.length == 0) {
            return perimeter;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int size = dfs(grid, r, c, visited);
                    return size;
                }
            }
        }
        return perimeter;
    }

    private static int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 ) {
            return 1;
        }
        if(visited[r][c]){
            return 0;
        }
        int size = 0;
        visited[r][c] = true;
        size += dfs(grid, r - 1, c, visited) + dfs(grid, r + 1, c, visited) + dfs(grid, r, c - 1, visited) + dfs(grid, r, c + 1, visited);
        return size;

    }
}
