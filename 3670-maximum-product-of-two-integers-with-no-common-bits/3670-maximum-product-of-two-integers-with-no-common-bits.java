// TC:O(n^2)
// class Solution {
//     public long maxProduct(int[] nums) {
//         int n = nums.length;
//         long maxProduct = 0;

//         // check all pairs
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if ((nums[i] & nums[j]) == 0) { // no common set bits
//                     long product = (long) nums[i] * nums[j];
//                     maxProduct = Math.max(product, maxProduct);
//                 }
//             }
//         }

//         return maxProduct;
//     }
// }


// Time: O(n + maxBit * 2^maxBit)
// where maxBit ≤ 20 if nums[i] ≤ 10^6.
// Space: O(2^maxBit)
class Solution {
    public long maxProduct(int[] nums) {
        // Step 1: Find maximum number in nums
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Step 2: Get number of bits in max
        int maxBit = Integer.toBinaryString(max).length(); 
        int maxMask = (int) Math.pow(2, maxBit) - 1; // mask of all 1's till maxBit

        // Step 3: dp[mask] stores the maximum number in nums equal to mask
        int dp[] = new int[maxMask + 1];
        for (int num : nums) {
            dp[num] = num;
        }

        // Step 4: SOS DP (Sum Over Subsets DP)
        for (int bit = 0; bit < maxBit; bit++) {
            for (int mask = 0; mask <= maxMask; mask++) {
                if ((mask & (1 << bit)) != 0) {
                    dp[mask] = Math.max(dp[mask], (dp[mask] ^ (1 << bit)));
                }
            }
        }

        // Step 5: Answer calculation
        long ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, (long) num * dp[num ^ maxMask]);
        }
        return ans;
    }
}
