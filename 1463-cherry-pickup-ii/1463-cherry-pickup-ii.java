class Solution {
    public int cherryPickup(int[][] grid) {
       
        int n = grid.length;
        int m = grid[0].length;

        Integer[][][] dp = new Integer[n][m][m];

        return helper(0, 0, m - 1, grid, dp);
    }

    private int helper(int row, int col1, int col2, int[][] grid, Integer[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;

    
        if(col1<0 || col1>=m || col2<0 || col2>=m)
            return Integer.MIN_VALUE;

      
        if(row==n - 1) {
            if (col1 == col2)
                return grid[row][col1];
            else
                return grid[row][col1] + grid[row][col2];
        }

        if(dp[row][col1][col2]!=null)
            return dp[row][col1][col2];

        int cherries;
        if (col1==col2)
            cherries = grid[row][col1];
        else
            cherries = grid[row][col1] + grid[row][col2];

        int max = Integer.MIN_VALUE;

      
        for (int d1 =-1; d1<= 1; d1++) {
            for (int d2=-1; d2<=1; d2++) {
                int next = helper(row+1, col1+d1, col2+d2, grid, dp);
                max = Math.max(max, next);
            }
        }

        cherries += max;

        return dp[row][col1][col2]=cherries;
    }
}
