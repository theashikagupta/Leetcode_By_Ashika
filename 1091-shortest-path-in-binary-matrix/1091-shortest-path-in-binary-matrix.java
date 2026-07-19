class Solution {
    int m, n;
    int[][] directions= {
    {-1, 0},  // Up
    {1, 0},   // Down
    {0, -1},  // Left
    {0, 1},   // Right
    {-1, -1}, // Top-Left
    {-1, 1},  // Top-Right
    {1, -1},  // Bottom-Left
    {1, 1}    // Bottom-Right
};
    public int shortestPathBinaryMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        Queue<int[]> que = new LinkedList<>();
        return bfs(0,0,1,matrix,que);



    }
    public int bfs(int i,int j,int len ,int[][]matrix, Queue<int[]> que){
        if(matrix[0][0]==1 || matrix[m-1][n-1]==1)  return -1;
        
        que.offer(new int[] {i,j,len});
        matrix[i][j]=1;
        
        while (!que.isEmpty()) {
            int[] cell = que.poll();
            int r= cell[0];
            int c= cell[1];
            int l=cell[2];
            if(r==m-1 && c==n-1) return l;
            
            for (int[] dir : directions) {
                
                int new_i = r + dir[0];
                int new_j = c + dir[1];
                
                if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && matrix[new_i][new_j] == 0) {
                    matrix[new_i][new_j] = 1;
                    que.add(new int[] {new_i, new_j,l+1});
                    
                }
                
            }
            
        }
        
        return -1;
    }
}