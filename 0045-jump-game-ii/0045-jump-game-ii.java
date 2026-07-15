class Solution {
    int []dp;
    public int jump(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,n,0);
    }
    public int solve(int[] nums,int n, int idx ){
        if(idx>=n-1) return 0;
        int ans=Integer.MAX_VALUE;
        if(dp[idx]!=-1) return dp[idx];
        for(int i=idx+1; i<=idx+nums[idx] && i<n ; i++){
            if(solve(nums,n,i)!=Integer.MAX_VALUE){
               ans=Math.min(ans,1+solve(nums,n,i));
            }
           
           
        }
        
        return dp[idx]=ans;
    }
}