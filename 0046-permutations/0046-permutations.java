class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        solve(nums,res,0);
        return res;
    }
    public void solve(int[] nums,List<List<Integer>> res,int idx ){
        int n=nums.length;
        if(idx==n){
            List<Integer> temp = new ArrayList<>();
            for (int x : nums) temp.add(x);
            res.add(temp);
            return;
        }
        for(int i=idx;i<n;i++){
            swap(nums,i,idx);
            solve(nums,res,idx+1);
           swap(nums,i,idx);
        }

    }
    public void swap(int[] nums,int i,int idx){
         int temp=nums[i];
         nums[i]=nums[idx];
         nums[idx]=temp;
    }



















































    //O(n!)
    //     List<List<Integer>> ans=new ArrayList<>();
    //     boolean[] visited=new boolean[nums.length];
    //     backtrack(nums,new ArrayList<>(),ans,visited);
    //     return ans;
    // }
    // private void backtrack(int[] nums,List<Integer> temp,List<List<Integer>> ans,boolean[] visited){
    //     int n=nums.length;
    //     //base case
    //     if(temp.size()==n){
    //         ans.add(new ArrayList<>(temp));
    //         return;
    //     }
    //     for(int i=0;i<n;i++){
        
    //         if(!visited[i]){
    //         //do
    //           visited[i]=true;
    //           temp.add(nums[i]);
    //           //explore
    //            backtrack(nums,temp,ans,visited);
    //           //undo
    //            visited[i]=false;
    //            temp.remove(temp.size()-1);
    //         }
        
    //     }
        
    // }
}