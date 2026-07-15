class Solution {
    static int[] dp;
    public boolean canJump(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,n,0);
    }
    public boolean solve(int[] nums,int n, int idx){
        if(idx==n-1) return true;
        if(dp[idx]!=-1) return dp[idx]==1;
        for(int i=1; i<=nums[idx]; i++){
            if(solve(nums,n,idx+i)==true){
                dp[idx]=1;
                return true;
            }
        }
        dp[idx]=0;
        return false;
    }
}