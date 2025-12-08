class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int sum=0;
        for(int s:stones){
            sum+=s;
        }
        int target=sum/2;
        int[][] dp=new int[n+1][target+1];
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                int pick=0;
                int w=stones[i-1];
                if(w<=j){
                   pick=w+dp[i-1][j-w];
                }
                int notPick=dp[i-1][j];
                dp[i][j]=Math.max(pick,notPick);
            }
        }
        int ans=sum-2*dp[n][target];
        return ans;
    }
}

