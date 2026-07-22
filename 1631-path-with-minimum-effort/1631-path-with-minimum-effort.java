class Solution {
    static int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int effort=curr[0];
            int r=curr[1];
            int c=curr[2];
            
            if(r==m-1 && c==n-1)  return effort;

            if(dist[r][c]<effort) continue;

            for(int[] d: dir){
              int newR=r+d[0];
              int newC=c+d[1]; 

              if(newR>=0 && newR<m && newC>=0 && newC<n) {
                int currDiff=Math.abs(heights[newR][newC]-heights[r][c]);
                int maxDiff=Math.max(currDiff,effort);
                if(maxDiff<dist[newR][newC]){
                    dist[newR][newC]=maxDiff;
                    pq.offer(new int[]{maxDiff,newR,newC});
                }
              }      
            }
            
        }
        return 0;
    }
}



