class Solution {
    int max=0;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp=new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                solve(matrix, i, j, dp);
            }
        }
        return max*max;
    }
    private int solve(char[][] matrix,int i,int j,int[][] dp ){
        if(i >= matrix.length || j >= matrix[0].length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(matrix[i][j]=='0'){
            dp[i][j]=0;
            return 0;
         }
         int right = solve(matrix, i, j + 1,dp);
         int diagonal = solve(matrix, i + 1, j + 1,dp);
         int bottom = solve(matrix, i + 1, j,dp);
      
        dp[i][j] = 1 + Math.min(right, Math.min(diagonal, bottom));
         max = Math.max(max, dp[i][j]);
         
       
         return dp[i][j];
        
    }
}