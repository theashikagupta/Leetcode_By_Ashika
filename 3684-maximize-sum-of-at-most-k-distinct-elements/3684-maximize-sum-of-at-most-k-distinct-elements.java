class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=n-1;i>=0 && res.size()<k ;i--){
            if(res.size()==0){
                res.add(nums[i]);
            }
            if(res.get(res.size()-1)!=nums[i]){
                res.add(nums[i]);
            }
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
    
        return ans;
    }
}