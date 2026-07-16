class Solution {
    public int splitArray(int[] nums, int k) {
        int low=Integer.MIN_VALUE; int sum=0;
        for(int num:nums){
            low=Math.max(low,num);
            sum+=num; 
        }

        int high=sum;

        while(low<high){
            int mid=low+(high-low)/2;
            if(possible(nums,mid,k)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;  
    }

    public boolean possible(int[] nums, int mid, int k){
        int partitions=1;
        int currSum=0;

        for(int num:nums){
            if(currSum+num<=mid){
                currSum+=num;
            }else{
                partitions++;
                currSum=num;
            }
        }
        return partitions<=k;
    }
}