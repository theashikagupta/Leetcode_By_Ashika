class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        // HashMap<Integer,Integer> map=new HashMap<>();
        // int idx=0;
        // for(int num:nums){
        //     if(map.containsKey(num) && Math.abs(idx-map.get(num))<=k){
        //         return true;
        //     }
        //     map.put(num,idx);
        //     idx++;
        // }
        // return false;

        HashSet<Integer> set=new HashSet<>();
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(Math.abs(i-j)>k){
                set.remove(nums[i]);
                i++;
            }
            if(set.contains(nums[j])){
                    return true;
            }
            else{set.add(nums[j]);}
        
        }
        return false;
    }
}