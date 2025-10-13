class Solution {
    public int findMin(int[] nums) {
        int si = 0;
        int ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid]>nums[ei]) {
                si=mid+1;
            }
            else if(nums[mid]<nums[ei]){
                ei=mid;
            }
            else{
                ei-=1;
            }

        }
        return nums[si];
    }
}