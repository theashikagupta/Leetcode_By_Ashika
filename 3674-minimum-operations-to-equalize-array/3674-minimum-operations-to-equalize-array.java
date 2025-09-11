class Solution {
    public int minOperations(int[] nums) {
        // Check if already all equal
        boolean allEqual = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[0]) {
                allEqual = false;
                break;
            }
        }
        if (allEqual) return 0;

        // Otherwise, one operation is always enough
        return 1;
    }
}
