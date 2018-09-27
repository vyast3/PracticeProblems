package com.practice.miscellaneous;

/*
https://leetcode.com/problems/word-search/description/
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (exist(board, r, c, word, 0)) return true;
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, int row, int coulumn, String word, int index) {
        if (index == word.length()) return true;
        if (row < 0 || coulumn < 0 || row >= board.length || coulumn >= board[row].length) return false;
        if (board[row][coulumn] != word.charAt(index)) return false;
        char temp = board[row][coulumn];
        board[row][coulumn] = '#';
        boolean exist = exist(board, row, coulumn + 1, word, index + 1)
                || exist(board, row, coulumn - 1, word, index + 1)
                || exist(board, row + 1, coulumn, word, index + 1)
                || exist(board, row - 1, coulumn, word, index + 1);
        board[row][coulumn] = temp;
        return exist;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "ABCES"));
        System.out.println(exist(board, "ABCD"));
    }
}
