class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[1001][1001];
        int m=s.length();
        int n=t.length();

        for(int i=0; i<=m; i++){
           Arrays.fill(dp[i],-1);
        }
        return solve(s,t,0,0,dp);
    }
    public int solve(String s, String t, int i,int j,int[][] dp){
        int m=s.length();
        int n=t.length();
        if(j==n) return 1;
        if(i==m && j<n) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            int take=solve(s,t,i+1,j+1,dp);
            int notTake=solve(s,t,i+1,j,dp);
            return dp[i][j]=take+notTake;
        }else{
            return dp[i][j]=solve(s,t,i+1,j,dp);
        }
    }
}