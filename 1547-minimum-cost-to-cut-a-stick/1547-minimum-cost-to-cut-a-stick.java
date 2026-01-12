class Solution {
    public int minCost(int n, int[] cuts) {

        int newcuts[]=new int[cuts.length+2];
        newcuts[0]=0;
        newcuts[newcuts.length-1]=n;

        Arrays.sort(cuts);

        for(int i=0;i<cuts.length;i++){
            newcuts[i+1]=cuts[i];
        }


        Integer dp[][]=new Integer[newcuts.length][newcuts.length];
        return solve(1,cuts.length,newcuts,dp); //newcuts.length -1 bhi kr skte

    
        
    }

    public int solve(int i,int j,int newcuts[],Integer dp[][]){
        if(i>j){
            return 0;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }

        int mini=Integer.MAX_VALUE;

        for(int idx=i;idx<=j;idx++){
            int cost=newcuts[j+1]-newcuts[i-1] + solve(i,idx-1,newcuts,dp) + solve(idx+1,j,newcuts,dp);
            mini=Math.min(mini,cost);
        }

        return dp[i][j]=mini;

    }
}