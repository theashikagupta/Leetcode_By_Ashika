class Solution {
    public int findCenter(int[][] edges) {
        int V, edge;
        
        V = edges.length+1;
        edge=edges.length;
    
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<=V;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edge;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        for(int i=0;i<V;i++){
            if(adjList.get(i).size()==V-1){
                return i;
            }
        }
        return -1;
    }
}