class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n=nums.size(); int k=0;
        int currLen=1;
        int prevLen=0;
        for(int i=1;i<n;i++){
            if(nums.get(i)>nums.get(i-1)){ //increasing order
               currLen++;
            }else{   //order break hogya
                prevLen=currLen;
                currLen=1;
            }
            if(currLen>=2*k){
                k=currLen/2;
            }
            k=Math.max(k,Math.min(currLen,prevLen));
            
        }
    return k;
    }
}
    