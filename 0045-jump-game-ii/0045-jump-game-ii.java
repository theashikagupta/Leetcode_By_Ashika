class Solution {
    int []dp;
    public int jump(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        for(int i=0; i<n-1; i++){
            dp[i]=Integer.MAX_VALUE;
        }
        dp[n-1]=0;
        
        for(int i=n-2; i>=0; i--){
            for(int j=1 ; j<=nums[i]&& i+j<n; j++){
               if(dp[i+j]!=Integer.MAX_VALUE){
                dp[i]=Math.min(1+dp[i+j],dp[i]);
               }
            }
            
        }
        return dp[0];
    }
}