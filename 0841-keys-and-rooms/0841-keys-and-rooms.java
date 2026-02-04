class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis=new boolean[rooms.size()];
        dfs(0, rooms, vis);
        int n=rooms.size();
        for(int i=0; i<n; i++){
           if(!vis[i])  return false;
        }
        return true;
    }
    public static void dfs(int curr, List<List<Integer>> rooms , boolean[] vis){
        
        vis[curr]=true;
        for(int room : rooms.get(curr)){
            if(vis[room]){
                dfs(room, rooms, vis);
            }
        }
    }
}