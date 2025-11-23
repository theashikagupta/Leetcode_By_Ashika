class Solution {
    int nums[];
    int n;
    Integer dp[][];
   
    public int maxSumDivThree(int[] nums) {
        this.nums=nums;
        n=nums.length;
        dp= new Integer[n][3];
        return solve(0,0);

        
    }
    private int solve(int i, int rem){
        if(i==n) return rem==0?0:Integer.MIN_VALUE/2;

        if(dp[i][rem]!=null) return dp[i][rem];

        int notTake= solve(i+1,rem);
        int newRemainder= (nums[i]+rem)%3;

        int take= nums[i]+ solve(i+1,newRemainder);

        return dp[i][rem]=Math.max(take,notTake);
        

    }
}