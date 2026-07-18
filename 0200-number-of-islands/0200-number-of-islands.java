class Solution {
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,1,-1};
    
    static class Pair{
        int row;
        int col;
    
        public Pair(int row, int col){
           this.row=row;
           this.col=col;
        }
    }

    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        boolean[][] vis=new boolean[m][n];
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int  j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    bfs(grid, i,j,vis,m,n,queue);
                    count++;
                }
            }
        }
     return count;
    }

    public void bfs(char[][] grid, int r, int c, boolean[][] vis, int m, int n, Queue<Pair> queue){
        queue.offer(new Pair(r,c));
        vis[r][c]=true;
        while(!queue.isEmpty()){
            Pair node=queue.poll();
            int R=node.row;
            int C=node.col;
            for(int k=0; k<4; k++){
            int newR=R+dr[k];
            int newC=C+dc[k];
                if(newR<m && newR>=0 && newC<n && newC>=0 && grid[newR][newC]=='1'&& vis[newR][newC]!=true){
                    vis[newR][newC]=true;
                    queue.offer(new Pair(newR,newC));
                   
                }
            }
        }
    }
}