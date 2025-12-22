class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] t = new int[n];
        Arrays.fill(t,1);
        int[] count = new int[n];
        Arrays.fill(count,1);
    
        int maxLIS=1;
        
        for(int i=1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]) {
                    if(t[i] == t[j] + 1)
                        count[i] += count[j];
                    else if(t[i] < t[j] + 1){
                        t[i] = t[j] + 1;
                        count[i] = count[j];
                        maxLIS=Math.max(maxLIS,t[i]);
                    }
                }
            }
        }

        int result=0;
        for(int i = 0; i<n; i++) {
            if(t[i] == maxLIS) {
                result += count[i];
            }
        }
        
        return result;
    }
}