package com.practice.miscellaneous;

/**
 * https://leetcode.com/problems/surrounded-regions/description/
 * <p>
 * Idea is simple: the only 'O's that will NOT change to 'X's are those at the edges and those horizontally or vertically
 * connected to the 'O's at the edges. So, first find out all the 'O's at the edges, mark them as '*', and keep checking
 * their surrounding 'O's and mark them as '*' as well. Then loop the board again, change 'O's to 'X's and change those
 * who was marked as '*'s to 'O's. Done
 *
 */
public class SorroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int column = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int r = 0; r < row; r++) {
            if (board[r][0] == 'O') helper(board, r, 0);
            if (board[r][column - 1] == 'O') helper(board, r, column - 1);
        }
        //Start from first and last row, turn '0' to '*'
        for (int c = 0; c < column; c++) {
            if (board[0][c] == 'O') helper(board, 0, c);
            if (board[row - 1][c] == 'O') helper(board, row - 1, c);
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == '*') board[r][c] = 'O';
            }
        }
    }

    private void helper(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] != 'O' ||  board[r][c] == '*') return;
        board[r][c] = '*';
        helper(board, r + 1, c);
        helper(board, r - 1, c);
        helper(board, r, c + 1);
        helper(board, r, c - 1);
    }
}
