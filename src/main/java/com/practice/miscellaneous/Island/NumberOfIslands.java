package com.practice.miscellaneous.Island;

/**
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] maze = {{0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 1}};
        System.out.println(count(maze));
        System.out.println(count(maze));
    }

    public static int count(int[][] maze) {
        int count = 0;
        if (maze == null || maze.length == 0) {
            return count;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[0].length; c++) {
                if (maze[r][c] == 1 && !visited[r][c]) {
                    count++;
                    dfs(maze, r, c, visited);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] maze, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= maze.length || c < 0 || c >= maze[0].length || maze[r][c] == 0 || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        dfs(maze, r - 1, c, visited);
        dfs(maze, r + 1, c, visited);
        dfs(maze, r, c - 1, visited);
        dfs(maze, r, c + 1, visited);
    }
}
