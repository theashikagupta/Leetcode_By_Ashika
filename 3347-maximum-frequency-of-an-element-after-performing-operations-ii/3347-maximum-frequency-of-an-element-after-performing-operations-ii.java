class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        HashSet<Integer> set=new HashSet<>();
        HashMap<Integer,Integer> freq=new HashMap<>();
        int ans=0;
        int maxNum=nums[nums.length-1];
        for(int n:nums){
            freq.put(n,freq.getOrDefault(n,0)+1);
            set.add(n);
            set.add(n+k);
            set.add(n-k);
        }
        for(int target:set){
           ans=Math.max(ans,maxFreq(nums,k,numOperations,freq,target));
        }
        return ans;
       }
    public int maxFreq(int[] nums,int k,int numOperations,HashMap<Integer,Integer> freq,int target){
        int left=getIndex(nums,target-k);
        int right=getIndex(nums, target+k+1);
        int operations=right-left-freq.getOrDefault(target,0);
        return Math.min(operations,numOperations) + freq.getOrDefault(target,0);
    }
    public int getIndex(int[] nums,int target){
        int l=0;int r=nums.length;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}