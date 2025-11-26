class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        backtrack(nums,new ArrayList<>(),ans,visited);
        return ans;
    }
    private void backtrack(int[] nums,List<Integer> temp,List<List<Integer>> ans,boolean[] visited){
        int n=nums.length;
        //base case
        if(temp.size()==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
        //do
            if(!visited[i]){
              visited[i]=true;
              temp.add(nums[i]);
              //explore
            backtrack(nums,temp,ans,visited);
            //undo
            visited[i]=false;
            temp.remove(temp.size()-1);
            }
        
        }
        
    }
}