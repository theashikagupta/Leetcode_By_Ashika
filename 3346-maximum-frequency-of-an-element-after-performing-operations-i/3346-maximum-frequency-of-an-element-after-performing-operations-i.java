class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        
    //     Arrays.sort(nums);
    //     HashMap<Integer,Integer> freq=new HashMap<>();
    //     int ans=0;
    //     int maxNum=nums[nums.length-1];
    //     for(int n:nums){
    //         freq.put(n,freq.getOrDefault(n,0)+1);
    //     }
    //     for(int target=1;target<=maxNum;target++){
    //        ans=Math.max(ans,maxFreq(nums,k,numOperations,freq,target));
    //     }
    //     return ans;
    // }
    // public int maxFreq(int[] nums,int k,int numOperations,HashMap<Integer,Integer> freq,int target){
    //     int left=getIndex(nums,target-k);
    //     int right=getIndex(nums, target+k+1);
    //     int operations=right-left-freq.getOrDefault(target,0);
    //     return Math.min(operations,numOperations) + freq.getOrDefault(target,0);
    // }
    // public int getIndex(int[] nums,int target){
    //     int l=0;int r=nums.length;
    //     while(l<r){
    //         int mid=(l+r)/2;
    //         if(nums[mid]<target){
    //             l=mid+1;
    //         }else{
    //             r=mid;
    //         }
    //     }
    //     return l;

    int maxVal = Arrays.stream(nums).max().getAsInt() + k;

        int[] diff = new int[maxVal + 2];
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            int l = Math.max(nums[i] - k, 0);
            int r = Math.min(nums[i] + k, maxVal);

            diff[l]++;
            diff[r + 1]--;
        }

        int result = 1;

        for (int target = 0; target <= maxVal; target++) {
            if (target > 0) diff[target] += diff[target - 1];

            int targetFreq = freq.getOrDefault(target, 0);
            int needConversion = diff[target] - targetFreq;

            int maxPossibleFreq = Math.min(needConversion, numOperations);
            result = Math.max(result, targetFreq + maxPossibleFreq);
        }

        return result;
    }
}

