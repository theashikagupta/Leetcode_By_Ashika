class Solution {
    public int minCost(int n, int[] cuts) {
        
        int m = cuts.length;
        
        // Create new array with 0 and n
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        
        Arrays.sort(arr);
        
        // dp[i][j] = min cost to cut stick between arr[i] and arr[j]
        int[][] dp = new int[m + 2][m + 2];
        
        // length = gap between cuts
        for (int len = 2; len < m + 2; len++) {
            for (int i = 0; i + len < m + 2; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i][k] + dp[k][j] + (arr[j] - arr[i])
                    );
                }
                
                // If no cut was possible
                if (dp[i][j] == Integer.MAX_VALUE) {
                    dp[i][j] = 0;
                }
            }
        }
        
        return dp[0][m + 1];
    }
}
