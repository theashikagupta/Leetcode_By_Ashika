class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;

        Arrays.sort(nums);
        int resSum=nums[0]+nums[1]+nums[2];
        int closest=Integer.MAX_VALUE;
        for(int k=0;k<n-2;k++){
            int i=k+1;
            int j=n-1;
           
            while(i<j){
                int sum=nums[k]+nums[i]+nums[j];
                if(sum==target){
                    return target;
                }else if(sum<target){
                    i++;
                }else j--;
                
                int diff=Math.abs(target-sum);
                if(diff<closest){
                    resSum=sum;
                    closest=diff;
                }
                
            }
            
        }
       return resSum;
    }
}