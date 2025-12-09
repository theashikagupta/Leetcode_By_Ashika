class Solution {
     private int recFunc(int index, int target, int coins[]) {
        // TC : 2^n
        // SC : O(n); Recursion stack space
        if (index == 0) {
            if (target%coins[0] == 0) return 1;
            return 0;
        }
        
        
        int notTake = recFunc(index-1, target, coins);
        
        int take = 0;
        
        if (target>=coins[index]) take = recFunc(index, target-coins[index], coins);
        
        
        return (take+notTake);      
    }

    private int memoFunc(int index, int target, int coins[], int[][] dp) {
         // TC : O(n*target) 
        // SC : O(n*target) + O(n); Recursion stack space
        if (index == 0) {
            if (target%coins[0] == 0) return 1;
            return 0;
        }
        
        if (dp[index][target]!=-1) return dp[index][target];
        int notTake = memoFunc(index-1, target, coins, dp);
        
        int take = 0;
        
        if (target>=coins[index]) take = memoFunc(index, target-coins[index], coins, dp);
        
        
        return dp[index][target]=(take + notTake);
        
        
    }

    private int tabuFunc(int target, int coins[], int[][] dp) {
        // TC : O(n*target) 
        // SC : O(n*target) 
        // base case 
        for (int j=0;j<=target;j++) {
            if (j%coins[0] == 0) dp[0][j] = 1;
            else dp[0][j] = 0;
        }
        
        for (int i=1;i<coins.length;i++) {
            for (int j=0;j<=target;j++) {
                int notTake = dp[i-1][j];
                int take = 0;
                if (j>=coins[i]) take = dp[i][j-coins[i]];
                dp[i][j] = take + notTake;
            }
            
        }
        
        return dp[coins.length-1][target];
    }

     private int spaceOpt(int target, int coins[], int[] prev) {
        // TC : O(n*target) 
        // SC : O(target) 
        // base case 
        for (int j=0;j<=target;j++) {
            if (j%coins[0] == 0) prev[j] = 1;
            else prev[j] = 0;
        }
        
        for (int i=1;i<coins.length;i++) {
            for (int j=0;j<=target;j++) {
                int notTake = prev[j];
                int take = 0;
                if (j>=coins[i]) take = prev[j-coins[i]];
                prev[j] = (take + notTake);
            }
            
        }
        
        return prev[target];
    }



    public int change(int amount, int[] coins) {
        int n = coins.length;

          int[][] dp = new int[n][amount+1];
        for (int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] = -1;
            }
        }

        int[] prev = new int[amount+1];
        for (int i=0;i<=amount;i++) {
            prev[i] = -1;
        }

        return spaceOpt(amount, coins, prev);
        //return tabuFunc(amount, coins, dp);
        //return memoFunc(n-1, amount, coins, dp);
        //return recFunc(n-1, amount, coins);
        
    }
}