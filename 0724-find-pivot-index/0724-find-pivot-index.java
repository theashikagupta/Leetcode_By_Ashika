class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0; // sum of all elements
        for (int num : nums) {
            total += num;
        }
        
        int leftSum = 0; // sum of elements to the left of current index
        for (int i = 0; i < nums.length; i++) {
            // Check if left sum equals right sum
            if (2 * leftSum + nums[i] == total) {
                return i; // pivot found
            }
            leftSum += nums[i]; // update left sum
        }
        
        return -1; // no pivot index found
    }
}