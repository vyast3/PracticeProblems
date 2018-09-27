package com.practice.codingInterview.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

class Maze2 {
    // M x N matrix
    private static final int M = 10;
    private static final int N = 10;

    // Check if it is possible to go to (x, y) from current position. The
    // function returns false if the cell has value 0 or already visited
    private static boolean isSafe(char mat[][], int visited[][], int x, int y) {
        return !(mat[x][y] == 0 || visited[x][y] != 0);
    }

    // if not a valid position, return false
    private static boolean isValid(int x, int y) {
        return (x < M && y < N && x >= 0 && y >= 0);
    }

    // Find Shortest Possible Route in a Matrix mat from source cell (0, 0)
    // to destination cell (x, y)

    // 'min_dist' stores length of longest path from source to destination
    // found so far and 'dist' maintains length of path from source cell to
    // the current cell (i, j)
    static List<List<Integer>> result = new ArrayList<>();

    public static void findShortestPath(char mat[][], int visited[][],
                                        int i, int j, int min_dist, int max, int dist) {
        // if destination is found, update min_dist
        if (mat[i][j] == 'R') {
            if (Integer.min(dist, min_dist) <= max) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(j);
                result.add(tmp);
                return;
            }

        }

        // set (i, j) cell as visited
        visited[i][j] = 1;

        // go to bottom cell
        if (isValid(i + 1, j) && isSafe(mat, visited, i + 1, j)) {
            findShortestPath(mat, visited, i + 1, j,
                    min_dist, max, dist + 1);
        }

        // go to right cell
        if (isValid(i, j + 1) && isSafe(mat, visited, i, j + 1)) {
            findShortestPath(mat, visited, i, j + 1,
                    min_dist, max, dist + 1);
        }

        // go to top cell
        if (isValid(i - 1, j) && isSafe(mat, visited, i - 1, j)) {
            findShortestPath(mat, visited, i - 1, j,
                    min_dist, max, dist + 1);
        }

        // go to left cell
        if (isValid(i, j - 1) && isSafe(mat, visited, i, j - 1)) {
            findShortestPath(mat, visited, i, j - 1,
                    min_dist, max, dist + 1);
        }

        // Backtrack - Remove (i, j) from visited matrix
        visited[i][j] = 0;

        return;
    }

    public static void main(String[] args) {
        char mat[][] =
                {
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                        {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                        {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                        {0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                };

        // construct a matrix to keep track of visited cells
        int[][] visited = new int[M][N];
        int[] driver = {0, 0};
        findShortestPath(mat, visited, driver[0], driver[1],
                Integer.MAX_VALUE, 5, 0);


    }


}
