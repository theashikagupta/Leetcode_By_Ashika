class Solution {
    private Integer[][][] dp;
    private int MAX_COST=(int)1e9;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        dp=new Integer[m][target+1][n+1];
        int  result=solve(0,0,0,houses,cost , m , n , target);
        return result>=MAX_COST?-1:result;
    }
    public int solve(int i, int neigh, int prevColor, int[] houses, int[][] cost, int m, int n, int target){
        if (neigh> target) return MAX_COST;
        if (i==m) {
            return neigh== target ? 0 : MAX_COST;
        }
        if (dp[i][neigh][prevColor] != null) {
            return dp[i][neigh][prevColor];
        }

        int minRes = MAX_COST;

        if(houses[i]!=0){
            int currColor=houses[i];
            int newNeigh=(currColor==prevColor)?neigh:neigh+1;
            minRes=solve(i + 1, newNeigh, currColor, houses, cost, m, n, target);
        } else {
            for (int color = 1; color <= n; color++) {
                int newNeigh = (color == prevColor) ? neigh : neigh + 1;
                int currCost = cost[i][color - 1] + solve(i + 1, newNeigh, color, houses, cost, m, n, target);
                minRes = Math.min(minRes, currCost);
            }
        }
        return dp[i][neigh][prevColor] = minRes;
     
    }
}