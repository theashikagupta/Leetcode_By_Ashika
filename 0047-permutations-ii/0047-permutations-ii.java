class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        solve(nums.length,map,res,new ArrayList<>());
        return res;
    }
    private void solve(int n,HashMap<Integer,Integer> map,List<List<Integer>> res,List<Integer> temp){
        if(temp.size()==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int key=entry.getKey();
            int freq=entry.getValue();
            if(freq>0){
                
                map.put(key, freq- 1);
                temp.add(key);
                solve(n,map,res,temp);
                map.put(key, freq);
                temp.remove(temp.size()-1);  

            }
        }
        
    }

}