class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int[] results=new int[n-k+1];
        int count=1;
        for(int i=1;i<n;i++){
           if(nums[i-1]+1==nums[i]){
            count++;
           }else{
            count=1;
           }
        if(i>=k-1){
            results[i-(k-1)]=(count>=k)? nums[i] :-1;
        }
        }
        
        if (k == 1) {
            for (int i = 0; i < n; i++) results[i] = nums[i];
        }
        return results;
    }
}