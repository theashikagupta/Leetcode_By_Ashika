class Solution {    //multiple source dfs
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static int rowL , colL;
    public void solve(char[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
       
        for(int j=0; j<colL; j++){
            if(grid[0][j]=='O'){
                dfs(0,j,grid);
            }
        }
        for(int j=0; j<colL; j++){
            if(grid[rowL-1][j]=='O'){
                dfs(rowL-1,j,grid);
            }
        }
        for(int i=0; i<rowL; i++){
            if(grid[i][0]=='O'){
                dfs(i,0,grid);
            }
        }
        
        for(int i=0; i<rowL; i++){
            if(grid[i][colL-1]=='O'){
                dfs(i,colL-1,grid);
            }
        }

        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]=='O'){
                    grid[i][j]='X';
                }
                else if(grid[i][j]=='#'){
                    grid[i][j]='O';
                }
            }    
        }

    }
    public static void dfs(int r , int c, char[][] grid){
        if(r<0  || c<0 || r>=rowL || c>=colL || grid[r][c]=='X')   return;
        if(grid[r][c]=='#') return ;
       
         
        grid[r][c]='#';
        for(int i=0;i<4;i++){
            dfs(r+dr[i],c+dc[i],grid);
        }
    }
}