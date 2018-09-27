package com.practice.miscellaneous;

/**
 * https://leetcode.com/articles/the-maze/
 */
public class TheMaze {
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start[0], start[1], destination[0], destination[1], visited);
    }

    private static boolean dfs(int[][] maze, int sRow, int sColumn, int eRow, int eColumn, boolean[][] visited) {
        if (visited[sRow][sColumn]) return false;
        if (sRow == eRow && sColumn == eColumn) return true;

        visited[sRow][sColumn] = true;

        int right = sColumn + 1;
        int left = sColumn - 1;
        int up = sRow - 1;
        int down = sRow + 1;

        while (right < maze[0].length && maze[sRow][right] == 0){
            right++;
        }
        if(dfs(maze, sRow, right - 1, eRow, eColumn, visited)) return true;

        while (left >= 0 && maze[sRow][left] == 0){
            left--;
        }
        if(dfs(maze, sRow, left + 1, eRow, eColumn, visited)) return true;

        while (up >= 0 && maze[sRow][up] == 0){
            up--;
        }
        if(dfs(maze, up + 1, sColumn, eRow, eColumn, visited)) return true;

        while (down < maze.length && maze[sRow][down] == 0){
            down++;
        }
        if(dfs(maze, down - 1, sColumn, eRow, eColumn, visited)) return true;

        return false;
    }

   /* private static boolean dfs(int[][] maze, int sRow, int sColumn, int dRow, int dColumn, boolean[][] visited) {
        if (visited[sRow][sColumn]) return false;
        if (sRow == dRow && sColumn == dColumn) return true;
        visited[sRow][sColumn] = true;
        int r = sColumn + 1, l = sColumn - 1, u = sRow - 1, d = sRow + 1;
        while (r < maze[0].length && maze[sRow][r] == 0) // right
            r++;
        if (dfs(maze, sRow, r - 1, dRow, dColumn, visited))
            return true;
        while (l >= 0 && maze[sRow][l] == 0) //left
            l--;
        if (dfs(maze, sRow, l + 1, dRow, dColumn, visited))
            return true;
        while (u >= 0 && maze[u][sColumn] == 0) //up
            u--;
        if (dfs(maze, u + 1, sColumn, dRow, dColumn, visited))
            return true;
        while (d < maze.length && maze[d][sColumn] == 0) //down
            d++;
        if (dfs(maze, d - 1, sColumn, dRow, dColumn, visited))
            return true;
        return false;
    }
    */


    public static void main(String[] args) {
        int[][] maze = {{0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] end = {4, 4};
        int[] end2 = {3, 2};
        System.out.println(hasPath(maze, start, end));
        System.out.println(hasPath(maze, start, end2));
    }


}
