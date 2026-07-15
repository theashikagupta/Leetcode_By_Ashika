class Solution {
    static boolean[] dp;
    public boolean canJump(int[] nums) {
        int n=nums.length;
        dp=new boolean[n];
        dp[0]=true;
        for(int i=1; i<n; i++){
            for(int j=i-1 ; j>=0; j--){
                if(dp[j] && nums[j]+j>=i){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n-1];
      }
    }