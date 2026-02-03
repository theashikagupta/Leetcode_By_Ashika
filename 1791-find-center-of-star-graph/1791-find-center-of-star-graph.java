class Solution {
    public int findCenter(int[][] edges) {
        int V, edge;
        
        V = edges.length+1;
        int[] outdeg=new int[V+1];

        for(int i=0; i<edges.length; i++){
            int u=edges[i][0];
            int v=edges[i][1];

            outdeg[u]++;
            outdeg[v]++;
            
        }
        for (int i = 1; i <= V; i++) {
            if (outdeg[i] == V - 1) {
                return i;
            }
        }

        return -1;
    }
}