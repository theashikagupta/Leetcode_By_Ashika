class Solution {
    int[] parent;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        parent = new int[n];

        // initialize parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // union if connected
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {  // only upper triangle needed
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // count unique parents
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                count++;
            }
        }

        return count;
    }

    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // path compression
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px != py) {
            parent[px] = py;
        }
    }
}
