class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        ArrayList<Integer> res=new ArrayList<>();
        for(int num:nums2){
            set.add(num);
        }
        for(int i=0;i<nums1.length;i++){
            if(set.contains(nums1[i])){
                res.add(nums1[i]);
                set.remove(nums1[i]);
            }
        }
        
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
        
    }
}