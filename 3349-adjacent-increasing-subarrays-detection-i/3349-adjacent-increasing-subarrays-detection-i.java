public class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
    //     int n = nums.size();
    //     for(int start=0;start+2*k<=n;start++){
    //         boolean first=isInc(nums,start,start+k);
    //         boolean second=isInc(nums,start+k,start+2*k);
    //         if(first && second){
    //             return true;
    //         }
    //     }
    //     return false;
        
    // }
    // public boolean isInc(List<Integer> nums,int s,int e){
    //     for(int i=s+1;i<e;i++){
    //         if(nums.get(i)<=nums.get(i-1)){
    //             return false;
    //         }
    //     }
    //     return true;


    int n=nums.size();
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
            return true;
        }
        if(Math.min(currLen,prevLen)>=k){
            return true;
        }
    }
    return false;
    }
}