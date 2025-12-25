class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        if (n < 3) return false;
        int[] less=new int[n];
        int[] greater=new int[n];

        less[0]=nums[0];
        for(int i=1;i<n;i++){
           less[i]=Math.min(less[i-1],nums[i]);
        }
        greater[n-1]=nums[n-1];
        for(int j=n-2;j>=0;j--){
            greater[j]=Math.max(greater[j+1],nums[j]);
        }
        
        for(int i=0;i<n;i++){
            if(less[i]<nums[i] && nums[i]<greater[i]){
                return true;
            }
        }
        return false;
    }
}