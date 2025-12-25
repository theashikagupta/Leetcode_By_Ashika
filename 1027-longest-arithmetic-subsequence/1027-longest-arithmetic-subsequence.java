class Solution {
    int[][] t=new int [1001][1003];
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        for(int i=0;i<1001;i++){
            Arrays.fill(t[i],-1);
        }
        if(n<=2) return n;
        
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int d=nums[j]-nums[i];
                res=Math.max(res, 2+ solve(nums,i,d));
            }
        }
        return res;
    }
    public int solve(int[] nums, int i,int d){
        if(i<0) return 0;
        if(t[i][d+501]!=-1) return t[i][d+501];
        int ans=0;

        for(int k=i-1 ;k>=0;k--){
            if(nums[i]-nums[k]==d){
                ans=Math.max(ans, 1+solve(nums,k,d));
            }
        }
        return  t[i][d+501]=ans;
    }
}