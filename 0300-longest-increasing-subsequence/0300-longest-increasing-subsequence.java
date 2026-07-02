class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
         Arrays.fill(dp,1);
         int ans=1;
        for(int i=0; i<nums.length; i++){
            for(int prev=0; prev<i; prev++){
               if(nums[prev]<nums[i]){
                 dp[i]=Math.max(dp[i],1+dp[prev]);
               }
            }
            ans=Math.max(dp[i],ans);
        }
        return ans;
    }
}