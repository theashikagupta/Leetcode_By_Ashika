class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;  // 0 coins to make amount 0
        }

        for (int j = 1; j <= amount; j++) {
            dp[0][j] =amount+1; // cannot make positive amount with 0 coins
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int notTake = dp[i - 1][j];
                int take = amount+1;
                if (coins[i - 1] <= j) {
                    take = 1 + dp[i][j - coins[i - 1]];
                }
                dp[i][j] = Math.min(notTake, take);
            }
        }

        return dp[n][amount] >= amount+1 ? -1 : dp[n][amount];
    }
}
