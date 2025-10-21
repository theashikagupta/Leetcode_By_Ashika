// class Solution {
//     public int maxFrequency(int[] nums, int k, int numOperations) {
        
//         Arrays.sort(nums);
//         HashMap<Integer,Integer> freq=new HashMap<>();
//         int ans=0;
//         int maxNum=nums[nums.length-1];
//         for(int n:nums){
//             freq.put(n,freq.getOrDefault(n,0)+1);
//         }
//         for(int target=1;target<=maxNum;target++){
//            ans=Math.max(ans,maxFreq(nums,k,numOperations,freq,target));
//         }
//         return ans;
//     }
//     public int maxFreq(int[] nums,int k,int numOperations,HashMap<Integer,Integer> freq,int target){
//         int left=getIndex(nums,target-k);
//         int right=getIndex(nums, target+k+1);
//         int operations=right-left-freq.getOrDefault(target,0);
//         return Math.min(operations,numOperations) + freq.getOrDefault(target,0);
//     }
//     public int getIndex(int[] nums,int target){
//         int l=0;int r=nums.length;
//         while(l<r){
//             int mid=(l+r)/2;
//             if(nums[mid]<target){
//                 l=mid+1;
//             }else{
//                 r=mid;
//             }
//         }
//         return l;
//     }
// }

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
       int max = 0, min = Integer.MAX_VALUE;

        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int[] freq = new int[max + 1];
        int[] prefix = new int[max + 1];
        for (int i : nums) {
            freq[i]++;
        }
        for (int i = min; i <= max; i++) {
            prefix[i] = prefix[i - 1] + freq[i];
        }
        int ans = 0;
        for (int i = min; i <= max; i++) {
            int low = 0;
            if (i - k - 1 > 0) {
                low = prefix[i - k - 1];
            }
            int high = 0;
            if (i + k <= max) {
                high = prefix[i + k];
            } else {
                high = prefix[max];
            }
            int toChange = high - low - freq[i];
            ans = Math.max(ans, freq[i] + (toChange >= numOperations ? numOperations : toChange));
        }
        return ans;
    }
}