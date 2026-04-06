// class Solution {
//     public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
//         return solve(0, n, 0, minProfit, group, profit);
//     }

//     private int solve(int i, int membersLeft, int currentProfit, int minProfit, int[] group, int[] profit) {
        
//         if (i==group.length) {
//             return currentProfit >= minProfit ? 1 : 0;
//         }

//         //skip
//         int ways = solve(i + 1, membersLeft, currentProfit, minProfit, group, profit);

//         //Commit this crime (if we have enough members)
//         if (membersLeft >= group[i]) {
//             int totalProfit = Math.min(minProfit, currentProfit + profit[i]);
//             ways += solve(i + 1, membersLeft - group[i], totalProfit, minProfit, group, profit);
//         }

       
//         return ways % 1_000_000_007;
//     }
// }




class Solution {
    int mod = 1_000_000_007;
    Integer[][][] memo;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        // memo[index][members_used][current_profit]
        memo = new Integer[group.length + 1][n + 1][minProfit + 1];
        return findWays(0, 0, 0, n, minProfit, group, profit);
    }

    private int findWays(int idx, int members, int curProfit, int n, int minProfit, int[] group, int[] profit) {
        if (idx == group.length) {
            return curProfit >= minProfit ? 1 : 0;
        }

        if (memo[idx][members][curProfit] != null) {
            return memo[idx][members][curProfit];
        }

        // Skip the crime
        long ways = findWays(idx + 1, members, curProfit, n, minProfit, group, profit);

        // Commit the crime (if enough members are available)
        if (members + group[idx] <= n) {
            int newProfit = Math.min(minProfit, curProfit + profit[idx]);
            ways = (ways + findWays(idx + 1, members + group[idx], newProfit, n, minProfit, group, profit)) % mod;
        }

        return memo[idx][members][curProfit] = (int) ways;
    }
}