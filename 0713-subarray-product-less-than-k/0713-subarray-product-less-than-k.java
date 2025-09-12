class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int count=0; int prod=1;
        
        for(int i=0;i<n;i++){
             for(int j=i;j<n;j++){
                 prod*=nums[j];
                 if(prod<k){ 
                    count++; 
                  }else {
                   break;               
                  } 
            } 
            prod=1;
        } 
        return count;

        // int n = nums.length;
        // int count = 0;

        // for (int i = 0; i < n; i++) {
        //     int prod = 1; 
        //     for (int j = i; j < n; j++) {
        //         prod *= nums[j];
        //         if (prod < k) {
        //             count++;
        //         } else {
                    
        //             break;
        //         }
        //     }
        // }

        // return count;



    //Optimized approach -O(n)
    //    if (k <= 1) return 0;
    //     int prod = 1, count = 0;
    //     int left = 0;
        
    //     for (int right = 0; right < nums.length; right++) {
    //         prod *= nums[right];
            
    //         while (prod >= k) {
    //             prod /= nums[left];
    //             left++;
    //         }
            
    //         count += (right - left + 1);
    //     }
        
    //     return count;

    }
}