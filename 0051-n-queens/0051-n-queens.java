class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        String[][] board = new String[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ".");
        }

        nQueens(board, 0, n, res);
        return res;
    }

    private void nQueens(String[][] board, int row, int n, List<List<String>> res) {
        if (row == n) {
            res.add(build(board, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {

                board[row][col] = "Q";     // corrected Board --> board
                nQueens(board, row + 1, n, res);
                board[row][col] = ".";     // corrected Board --> board
            }
        }
    }

    private boolean isSafe(String[][] board, int row, int col, int n) {

        // vertical check
        for (int i = 0; i < row; i++) {
            if (board[i][col].equals("Q")) {
                return false;
            }
        }

        // left diagonal check
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }

        // right diagonal check
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }

        return true;
    }

    private List<String> build(String[][] board, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) sb.append(board[i][j]);
            list.add(sb.toString());
        }
        return list;
    }
}
