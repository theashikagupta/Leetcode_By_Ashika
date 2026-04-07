// class Solution {
//     int MOD = 1000000007;

//     public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//         return solve(m, n, maxMove, startRow, startColumn);
//     }

//     private int solve(int m, int n, int movesLeft, int r, int c) {
       
//         if (r < 0 || r >= m || c < 0 || c >= n) {
//             return 1;
//         }

      
//         if (movesLeft == 0) {
//             return 0;
//         }

//         long up = solve(m, n, movesLeft - 1, r - 1, c);
//         long down = solve(m, n, movesLeft - 1, r + 1, c);
//         long left = solve(m, n, movesLeft - 1, r, c - 1);
//         long right = solve(m, n, movesLeft - 1, r, c + 1);

//         return (int)((up + down + left + right) % MOD);
//     }
// }


class Solution {
    int MOD = 1000000007;
    int[][][] dp;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(m, n, maxMove, startRow, startColumn);
    }

    private int solve(int m, int n, int movesLeft, int r, int c) {
       
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 1;
        }

      
        if (movesLeft == 0) {
            return 0;
        }

        if (dp[r][c][movesLeft] != -1) {
            return dp[r][c][movesLeft];
        }

        long up = solve(m, n, movesLeft - 1, r - 1, c);
        long down = solve(m, n, movesLeft - 1, r + 1, c);
        long left = solve(m, n, movesLeft - 1, r, c - 1);
        long right = solve(m, n, movesLeft - 1, r, c + 1);

        dp[r][c][movesLeft] = (int)((up + down + left + right) % MOD);
        return dp[r][c][movesLeft];
    }
}