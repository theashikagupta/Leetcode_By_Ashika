class Solution {
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,1,-1};
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        boolean[][] vis=new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int  j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(grid, i,j,vis,m,n);
                    count++;
                }
            }
        }
     return count;
    }

    public void dfs(char[][] grid, int r, int c, boolean[][] vis, int m, int n){
        vis[r][c]=true;
        for(int k=0; k<4; k++){
            int newR=r+dr[k];
            int newC=c+dc[k];
            if(newR<m && newR>=0 && newC<n && newC>=0 && grid[newR][newC]=='1'&& vis[newR][newC]!=true){
                dfs(grid,newR,newC,vis,m,n);
            }
        }
    }
}