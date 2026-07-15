class Solution {
    static boolean[] dp;
    public boolean canJump(int[] nums) {
        int n=nums.length;
        // dp=new boolean[n];
        // dp[0]=true;
        // for(int i=1; i<n; i++){
        //     for(int j=i-1 ; j>=0; j--){
        //         if(dp[j] && nums[j]+j>=i){
        //             dp[i]=true;
        //             break;
        //         }
        //     }
        // }
        // return dp[n-1];

        int maxReachable=0;

        for(int i=0; i<n; i++){
            if(i>maxReachable) return false;
        
            maxReachable=Math.max(maxReachable,i+nums[i]);
        }
        return true;
        
      }
    }