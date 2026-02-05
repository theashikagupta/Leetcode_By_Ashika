class Solution {
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static int rowL , colL;
    static int perimeter;
    public int islandPerimeter(int[][] grid) {
      
        rowL=grid.length;
        colL=grid[0].length;
        boolean[][] vis=new boolean[rowL][colL];
     
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(!vis[i][j] && grid[i][j]==1){
                    return dfs(i,j,vis,grid);
                    
                }
            }    
        }
        return 0;
    }
    public static int dfs(int r , int c ,boolean[][] vis, int[][] grid){
        if(r<0 || c<0 || r>=rowL || c>=colL || grid[r][c]==0){
            return 1;}
        if(vis[r][c]==true ) return 0;
        vis[r][c]=true;
        perimeter=0;
        for(int i=0; i<4 ;i++){
            perimeter+=dfs(dr[i]+r,dc[i]+c,vis,grid);
        }
        return perimeter;
        
    }
}