class Solution {
    public int coinChange(int[] coins, int amount) 
    {
       int n=coins.length;
       int[][] dp=new int[n][amount+1];
       for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
       int ans=solveMemo(n-1,amount,coins,dp);
       return (ans>=(int)1e9?-1:ans);
    }
    // private int solveRec(int i,int amount,int[] coins)
    // {
    //     if(amount==0) return 0;
    //     if(i==0) {
    //     if(amount%coins[0]==0){
    //         return amount/coins[0];
    //     }
    //     else{
    //         return (int)1e9;
    //     }
    //    }

    //    int notTake=solveRec(i-1,amount,coins);
    //    int take=(int)1e9;
    //    if(coins[i]<=amount){
    //     take=1+solveRec(i,amount-coins[i],coins);
    //    }
    //    return Math.min(take,notTake);
    // }


    private int solveMemo(int i,int amount,int[] coins,int[][] dp){
        if(amount==0) return 0;

        if(i==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }else{
                return (int)1e9;
            }
        }

        if(dp[i][amount]!=-1) return dp[i][amount];

        int notTake=solveMemo(i-1,amount,coins,dp);
        int take=(int)1e9;
        if(coins[i]<=amount){
           take=1+ solveMemo(i,amount-coins[i],coins,dp);
        }
        return dp[i][amount]=Math.min(take,notTake);
    }
}
