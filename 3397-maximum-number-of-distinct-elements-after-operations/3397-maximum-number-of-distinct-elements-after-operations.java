class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        
        Arrays.sort(nums);
        int count=0; int preMax=Integer.MIN_VALUE;
        for(int n:nums){
            int lowerBound=n-k;
            int upperBound=n+k;
            if(preMax <lowerBound ){
                preMax=lowerBound;
                count++;
            }else if(preMax < upperBound ){
                preMax++;
                count++;
            }

            
        }
        return count;
    }
}