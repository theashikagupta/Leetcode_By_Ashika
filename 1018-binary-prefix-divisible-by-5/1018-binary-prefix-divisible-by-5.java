class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res=new ArrayList<>();
        int curr=0;
        for(int x:nums){
            curr=((2*curr)+x)%5;
            res.add(curr==0);
        }
        return res;
    }
}