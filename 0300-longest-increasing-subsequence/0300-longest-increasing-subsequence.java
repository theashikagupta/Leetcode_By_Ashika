class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> tails=new ArrayList<>();
        for(int x:nums) {
            int idx=lowerBound(tails,x);

            if(tails.size()==idx){
                tails.add(x);
            }else{
                tails.set(idx,x);
            }
        }
        return tails.size();
    }
    public int lowerBound(ArrayList<Integer> arr, int target){
        int low=0; int high=arr.size();
        while(low<high){
            int mid=(low+high)/2;
            if(arr.get(mid)>=target) 
                high=mid;
            else 
                low=mid+1;
        }  
        return low;
    }
}