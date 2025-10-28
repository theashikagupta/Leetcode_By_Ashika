class Solution {
    public int countValidSelections(int[] nums) {
        int len=nums.length, res=0;
        for (int i=0; i<len; i++) {
            if(nums[i]==0){
                if(allZeroes(nums,1,i)){
                    res+=1;
                }
                if(allZeroes(nums,-1,i)){
                    res+=1;
                }
            }
        }
        return res;
    }
    private boolean allZeroes(int[] nums, int dir, int start){
        int[] arr=nums.clone();
        int direction=dir;
        int curr=start;

        while(curr>=0 && curr<arr.length){
            if(arr[curr]==0){
                curr+=direction;
            }else{
                arr[curr]-=1;
                direction=-direction;
                curr+=direction;
            }
        }
        for(int x:arr){
            if(x!=0) return false;
        }
        return true;
    }
}
