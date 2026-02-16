class Solution {
    boolean[][] vis;
    int[][][] dp;
    boolean check(List<List<Integer>> grid, int row, int col, int h) {
        int m = grid.size(); int n = grid.get(0).size();
        if (row >= m || col >= n || row<0 || col<0 || h<=0 || vis[row][col]) return false;
        if (row==m-1 && col==n-1) {
            return h>grid.get(row).get(col);
        }
        if (dp[row][col][h]!=-1) return dp[row][col][h]==1;
        vis[row][col] = true;
        boolean up = check(grid,row-1,col,h-grid.get(row).get(col));
        boolean down = check(grid,row+1,col,h-grid.get(row).get(col));
        boolean left = check(grid,row,col-1,h-grid.get(row).get(col));
        boolean right = check(grid,row,col+1,h-grid.get(row).get(col));
        vis[row][col] = false;
        boolean result = up || down || left || right;
        if(result){
            dp[row][col][h]=1;
        }
        else dp[row][col][h]=0;
        return result;
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        dp = new int[m][n][health+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        vis = new boolean[m][n];
        return check(grid, 0, 0, health);
    }
}