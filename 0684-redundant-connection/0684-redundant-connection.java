class Solution {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        parent = new int[n + 1];
        rank = new int[n + 1];
        
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        int[] ans = new int[2];
        
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if(find(u) == find(v)) {
                ans = edge;   // cycle edge
            } else {
                union(u, v);
            }
        }
        
        return ans;
    }
    
    int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if(rootX == rootY) return;
        
        if(rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if(rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
}
