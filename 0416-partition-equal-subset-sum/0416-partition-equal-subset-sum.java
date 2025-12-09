class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        int[][] dp=new int[n+1][target+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveMemo(0,target,nums,dp);
    }
    private boolean solveMemo(int idx,int target, int[] nums,int[][] dp){
        int n=nums.length;
        if(target==0) return true;
        if(idx>=n) return false;

        if (dp[idx][target] != -1) {
            return dp[idx][target] == 1;
        }
        boolean notTake=solveMemo(idx+1,target,nums,dp);
        boolean take=false;
        if(nums[idx]<=target){
            take=solveMemo(idx+1,target-nums[idx],nums,dp);
        }
        dp[idx][target]=take||notTake?1:0;
        return take||notTake;
    
    
        
    }
}