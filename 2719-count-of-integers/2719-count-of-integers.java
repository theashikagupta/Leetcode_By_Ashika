class Solution {
    int[][][] dp;
    int mod = 1000000007;

    public int count(String num1, String num2, int min_sum, int max_sum) {
        dp = new int[num2.length()][max_sum + 1][2];
        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -1);

        int high = solve(num2, 0, 0, 1, min_sum, max_sum);

        dp = new int[num1.length()][max_sum + 1][2];
        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -1);

        int low = solve(num1, 0, 0, 1, min_sum, max_sum);

        // check num1 itself
        int sum = 0;
        for (char c : num1.toCharArray()) sum += c - '0';
        if (sum >= min_sum && sum <= max_sum) low--;

        return (high - low + mod) % mod;
    }

    private int solve(String num, int idx, int sum, int tight,
                      int min_sum, int max_sum) {

        if (sum > max_sum) return 0;

        if (idx == num.length()) {
            return (sum >= min_sum && sum <= max_sum) ? 1 : 0;
        }

        if (dp[idx][sum][tight] != -1)
            return dp[idx][sum][tight];

        int limit = tight == 1 ? num.charAt(idx) - '0' : 9;
        int ans = 0;

        for (int d = 0; d <= limit; d++) {
            int newTight = (tight == 1 && d == limit) ? 1 : 0;
            ans = (ans + solve(num, idx + 1, sum + d, newTight,
                               min_sum, max_sum)) % mod;
        }

        return dp[idx][sum][tight] = ans;
    }
}
