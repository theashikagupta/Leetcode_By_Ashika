class Solution {
    public int pivotIndex(int[] nums) {
        // // int total = 0; // sum of all elements
        // // for (int num : nums) {
        // //     total += num;
        // // }
        
        // // int leftSum = 0; // sum of elements to the left of current index
        // // for (int i = 0; i < nums.length; i++) {
        // //     // Check if left sum equals right sum
        // //     if (2 * leftSum + nums[i] == total) {
        // //         return i; // pivot found
        // //     }
        // //     leftSum += nums[i]; // update left sum
        // // }
        
        // // return -1; // no pivot index found



        // int n = nums.length;
        // int[] prefix = new int[n];
        
        // // build prefix sum
        // prefix[0] = nums[0];
        // for (int i = 1; i < n; i++) {
        //     prefix[i] = prefix[i - 1] + nums[i];
        // }
        
        // for (int i = 0; i < n; i++) {
        //     int leftSum = (i == 0) ? 0 : prefix[i - 1];
        //     int rightSum = prefix[n - 1] - prefix[i];
        //     if (leftSum == rightSum) {
        //         return i;
        //     }
        // }
        
        // return -1; // no pivot







    int[] prefix=new int[nums.length];
    int[] suffix=new int[nums.length];
    prefix[0]=nums[0]; suffix[nums.length-1]=nums[nums.length-1];
    for(int i=1;i<nums.length;i++){
       prefix[i]=prefix[i-1]+nums[i];
    }

    for(int i=nums.length-2; i>=0; i--){
       suffix[i]=suffix[i+1]+nums[i];
    }
    

    for(int i=0;i<nums.length;i++){
       if(prefix[i]==suffix[i]){
        return i;
       }
    }

        

    return -1;

















    }
}