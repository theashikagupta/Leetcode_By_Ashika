class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[rooms.size()];
        vis[0]=true;
        q.offer(0);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int room : rooms.get(curr)){
                if(vis[room]==false){
                   vis[room]=true;
                   q.offer(room);
                }
            }
            
        }
        for(int i=0;i<n;i++){
           if(!vis[i])  return false;
        }
        return true;
    }
}