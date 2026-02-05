class Solution {
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static int rowL , colL;
    public int numIslands(char[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][] vis=new boolean[rowL][colL];
        int components=0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                       dfs(i,j,vis,grid);
                       components++;
                }
            }    
        }
        return components;
    }
    public static void dfs(int r , int c , boolean[][] vis, char[][] grid){
          if(r<0  || c<0 || r>=rowL || c>=colL || grid[r][c]=='0')   return;
          if(vis[r][c]==true)  return;
          vis[r][c]=true;
          
          for(int i=0;i<4;i++){
              dfs(r+dr[i],c+dc[j],vis,grid);
          }
      }
}