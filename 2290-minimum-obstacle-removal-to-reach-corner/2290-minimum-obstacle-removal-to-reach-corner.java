import java.util.*;

class Solution {
    static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int dist[][] = new int[m][n];
        
        for(int i = 0; i < m; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        
        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;
        
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int cost = curr[2];
            
            if(r == m-1 && c == n-1){
                return cost;
            }
            
            for(int i = 0; i < 4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    
                    int newCost = cost + grid[nr][nc];
                    
                    if(newCost < dist[nr][nc]){
                        dist[nr][nc] = newCost;
                        pq.offer(new int[]{nr, nc, newCost});
                    }
                }
            }
        }
        
        return -1;
    }
}
