class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // int n=nums.length; 
        //Brute force

        // for(int i=0;i<n;i++){
        //     int sum=0;
        //     for(int j=i;j<n;j++){
        //         int len=j-i+1;          
        //         sum+=nums[j];
        //             if(len>=2 && sum%k==0){
        //                 return true;
        //             }

                
        //     }
        // }
        // return false;

        //Optimal

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // remainder 0 at index -1 (base case)

        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int mod = prefix % k;
            // if (mod < 0) mod += k; // handle negative numbers

            if (map.containsKey(mod)) {
                if (i - map.get(mod) >= 2) return true;
            } else {
                map.put(mod, i); // store first occurrence
            }
        }
        return false;
    }
}

  