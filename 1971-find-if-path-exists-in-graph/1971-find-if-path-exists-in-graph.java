class Solution {
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        Boolean[] vis=new boolean[n];
        vis[src]=true;
        q.offer(src);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int adj : adjList.get(curr)){
                if(vis[adj]==false){
                   vis[adj]=true;
                   q.offer(adj);
                }
            }
            
        }
        if(vis[dest]==true){
            return true;
        }
        return false;
    }
}