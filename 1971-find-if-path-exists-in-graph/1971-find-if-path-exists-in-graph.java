class Solution {
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] vis=new boolean[n];
        dfs(src,adjList, vis);
        return vis[dest];
    }
    public static boolean dfs(int node , ArrayList<ArrayList<Integer>> adjList, boolean[] vis){
        vis[node]=true;
        for(int adj : adjList.get(node)){
            if(!vis[adj]){
                dfs(adj, adjList, vis);
            }
        }
    }
}