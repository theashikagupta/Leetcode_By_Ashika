class Solution {
    int[] dp;

    public int rob(int[] nums) {
    //     int n=nums.length;
    //     dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     return solve(nums, 0);
    // }

    // private int solve(int[] nums, int i) {
        // if (i >= nums.length) return 0;

        // if (dp[i]!= -1) return dp[i];

        // int take =nums[i] + solve(nums,i+2);
        // int notTake = solve(nums,i+1);

        // return dp[i] = Math.max(take, notTake);

        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n-1];
    }
}
