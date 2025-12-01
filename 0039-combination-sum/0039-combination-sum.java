class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,0,target,new ArrayList<>(),ans);
        return ans;
    }
    private void helper(int[] candidates,int i,  int target,List<Integer> curr,List<List<Integer>> ans){
        if(target==0 ){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i==candidates.length ||target<0) return;
    
            curr.add(candidates[i]);
            //multiple include
            helper(candidates, i,target-candidates[i], curr, ans);
            curr.remove(curr.size() - 1); 
            //exclude
            helper(candidates, i+1,target, curr,ans);
        
    }
}