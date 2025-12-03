class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // fill dp with -1 meaning "not calculated yet"
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(0, 0, dp);


        //Tabulation -- bottom up
        // int[][] dp = new int[m][n];
        
        // for (int j = 0; j < n; j++) {
        //     dp[0][j] = 1;
        // }

        // for (int i = 0; i < m; i++) {
        //     dp[i][0] = 1;
        // }

        // for (int i = 1; i < m; i++) {
        //     for (int j = 1; j < n; j++) {
        //         dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        //     }
        // }

        // return dp[m - 1][n - 1];

        //Memoization -- TopDown

       
    }
    private int solve(int i,int j,int[][] dp ){
         if(i==m-1 || j==n-1){
            return 1;
        }
        if(i<0 || i>=m || j<0 || j>=n){
            return 0;
        }
        
        if (dp[i][j] != -1) return dp[i][j];
        dp[i][j] = solve(i , j+1, dp) + solve(i+1, j , dp);
        
        return dp[i][j];
    }
}


    //gives TLE Through recursion

    // private int solve(int i,int j, int m,int n){
    //     if(i==m-1 && j==n-1) return 1;
    //     if(i<0 || i>=m || j<0 || j>=n){
    //         return 0;
    //     }

    //     int right=solve(i,j+1,m,n);
    //     int down=solve(i+1,j,m,n);
    //     return right+down;
    // }


    
