class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        
        // Arrays.sort(nums);
        // int count=0; int preMax=Integer.MIN_VALUE;
        // for(int n:nums){
        //     int lowerBound=n-k;
        //     int upperBound=n+k;
        //     if(preMax <lowerBound ){
        //         preMax=lowerBound;
        //         count++;
        //     }else if(preMax < upperBound ){
        //         preMax++;
        //         count++;
        //     }

            
        // }
        // return count;


       
        if (nums.length <= (k << 1) + 1) return nums.length;
        Arrays.sort(nums);
        int distinct = 0;
        int l = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int m = Math.max(l+1, nums[i]-k);
            if (m <= nums[i]+k) {
                distinct++;
                l = m;
            }
        }
        return distinct;
    }
}
  