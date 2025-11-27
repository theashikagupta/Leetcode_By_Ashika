class Solution {

    private boolean solved = false;

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private void solve(char[][] board, int row, int col) {
        if (solved) return;  // stop all recursion

        if (row == 9) {      
            solved = true;   // Sudoku completed
            return;
        }

        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;

        if (board[row][col] != '.') {
            solve(board, nextRow, nextCol);
            return;
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;

                solve(board, nextRow, nextCol);

                if (solved) return;  // do NOT undo if solved

                board[row][col] = '.';  // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int r, int c, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num) return false;
            if (board[i][c] == num) return false;

            int boxRow = 3 * (r / 3) + i / 3;
            int boxCol = 3 * (c / 3) + i % 3;

            if (board[boxRow][boxCol] == num) return false;
        }
        return true;
    }
}
