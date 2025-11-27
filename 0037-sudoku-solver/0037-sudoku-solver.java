class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        int n = board.length;

        if (row==n) return true;

        int nextRow = (col==n-1) ? row+1:row;
        int nextCol = (col==n-1) ? 0:col+1;

        if (board[row][col]!='.') 
            return solve(board, nextRow, nextCol);

        for (char num = '1'; num <= '9'; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board, nextRow, nextCol)) 
                    return true;
                board[row][col] = '.';
            }
        }

        return false;
    }

    private boolean isSafe(char[][] board, int r, int c, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num) return false;
            if (board[i][c] == num) return false;
            int boxRow = 3 *(r/3) + i/3;
            int boxCol = 3 *(c/3) + i%3;
            if (board[boxRow][boxCol] == num) return false;
        }
        return true;
    }
}
