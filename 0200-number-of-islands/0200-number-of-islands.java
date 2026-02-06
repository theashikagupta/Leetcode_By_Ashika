class Solution {
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static int rowL , colL;
    static char[] dir={'U', 'D', 'L' ,'R'};
    
    static class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numIslands(char[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        int components=0;
        
        for(int i=0;i< rowL;i++){
            for(int j=0;j<colL;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    bfs(i,j,vis,grid);
                    components++;
                }
            }
        }
        return components;
    }
    // public static void dfs(int r , int c , boolean[][] vis, char[][] grid){
    //       if(r<0  || c<0 || r>=rowL || c>=colL || grid[r][c]=='0')   return;
    //       if(vis[r][c]==true)  return;
    //       vis[r][c]=true;
          
    //       for(int i=0;i<4;i++){
    //           dfs(r+dr[i],c+dc[i],vis,grid);
    //       }
    //   }
    public static void bfs(int r ,int c, boolean[][] vis, char[][] grid){
        Queue<Pair> q=new LinkedList<>();
        vis[r][c]=true;
        q.offer(new Pair(r,c));

        while(!q.isEmpty()){
            Pair curr=q.poll();
            int R=curr.row;
            int C=curr.col;

            for(int i=0;i<4;i++){
                int nRow=R+dr[i];
                int nCol=C+dc[i];
                if(nRow>=0 && nCol>=0 && nRow<rowL && nCol<colL && !vis[nRow][nCol] && grid[nRow][nCol]=='1')          {
                    vis[nRow][nCol]=true;
                    q.offer(new Pair(nRow,nCol));
                }
            }

        }
    }
}