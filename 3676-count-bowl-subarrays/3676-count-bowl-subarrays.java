class Solution {  //TC:O(n) SC:O(n)
    public long bowlSubarrays(int[] nums) {
        int n=nums.length;
        int max=0;
        int[] lmax=new int[n];
        int[] rmax=new int[n];
        for(int i=0;i<n;i++){
           max=Math.max(nums[i],max);
           lmax[i]=max;
        }
        max=0;
        for(int i=n-1;i>=0;i--){
           max=Math.max(nums[i],max);
           rmax[i]=max;
        }
        int count=0;
        for(int i=0;i<n;i++){
           if(nums[i]!=lmax[i] && nums[i]!=rmax[i]){
            count++;
           }
        }
        return count;
    }
}
