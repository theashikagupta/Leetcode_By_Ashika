class Solution {
    public int missingNumber(int[] nums) {
        int m=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            m^=i+1;
            m^=nums[i];
        }
       
        return m;

        
    }
}
//  for(int i=0;i<n;i++){
//             m^=nums[i];
//         }