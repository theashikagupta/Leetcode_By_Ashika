class Solution {
    static int comp;
    static int[] parent;
    static int[] rank;

    public int removeStones(int[][] stones) {
        int n=stones.length;
        comp=n;
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }

        for(int i=0;i<n;i++){
            for(int j=i+1 ;j<n; j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1] ){
                    union(i,j);
                    comp--;
                }
            }
        }
        return n-comp;
    }
    public static int find(int x) {
        if (parent[x] == x) {
             return x;
        }
        return  parent[x] = find(parent[x]);  
    }

    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return; 

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
}