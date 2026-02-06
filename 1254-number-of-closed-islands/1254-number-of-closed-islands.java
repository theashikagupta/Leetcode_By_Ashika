class Solution {
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static int rowL , colL;

    public int closedIsland(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        for(int j=0; j<colL; j++){
            if(grid[0][j]==0){
                dfs(0,j,vis,grid);
            }
        }
        for(int j=0; j<colL; j++){
            if(grid[rowL-1][j]==0){
                dfs(rowL-1,j,vis,grid);
            }
        }
        for(int i=0; i<rowL; i++){
            if(grid[i][0]==0){
                dfs(i,0,vis,grid);
            }
        }
        
        for(int i=0; i<rowL; i++){
            if(grid[i][colL-1]==0){
                dfs(i,colL-1,vis,grid);
            }
        }
        
        int components=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(!vis[i][j] && grid[i][j]==0){
                       dfs(i,j,vis,grid);
                       components++;
                }
            }    
        }
        return components;
    }
    public static void dfs(int r , int c, boolean[][] vis, int[][] grid){
        if(r<0  || c<0 || r>=rowL || c>=colL || grid[r][c]==1)   return;
        if(grid[r][c]==2) return ;
        if(vis[r][c]==true)  return;
        vis[r][c]=true;
        grid[r][c]=2;
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],vis,grid);
        }
    }
}