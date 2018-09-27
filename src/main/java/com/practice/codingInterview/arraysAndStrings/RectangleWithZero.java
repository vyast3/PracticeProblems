package com.practice.codingInterview.arraysAndStrings;

public class RectangleWithZero {

    public static void main(String[] args) {

        int[][] mat = {{1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1}, {1, 0, 1, 1, 1, 1, 1}, {1, 0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}};

        findIndex(mat);
    }

    private static void findIndex(int[][] mat) {
        StringBuilder output = new StringBuilder();
        int[][] visited = mat.clone();
        int index = -1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    output.append("[" + i + " " + j + ",");
                    findEnd(output, i, j, visited);
                    output.append("]" + ",");
                }
            }
        }
        System.out.println(output.substring(0, output.length() - 1));
    }

    private static void findEnd(StringBuilder set, int r, int c, int[][] visited) {
        int i = 0;
        int j = 0;
        for (i = r; i < visited.length; i++) {
            if (visited[i][c] == 1) {
                break;
            }
            for (j = c; j < visited[0].length; j++) {
                if (visited[i][j] == 1) {
                    break;
                }
                // to mark visited
                visited[i][j] = -1;
            }
        }
        //last mein to
        i = i - 1;
        j = j - 1;
        set.append(i).append(" ").append(j);
    }
}
