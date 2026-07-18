class Solution {
    private int[] dr={-1,1,0,0};
    private int[] dc={0,0,1,-1};
    boolean[][] vis;
    Queue<Pair> q;
    public class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r=r;
            this.c=c; 
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0; 
        q=new LinkedList<>();
        vis=new boolean[n][m];
        for(int i=0; i<n ; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                   fresh++;
                }
                else if(grid[i][j]==2){
                   q.offer(new Pair(i,j));   
                   vis[i][j]=true; 
                }  
            }
        }

        int time=0;
        
        
        while(!q.isEmpty()){
            int size=q.size();
            boolean flag=false;
            for(int j=0; j<size; j++){
                Pair node=q.poll();
                int R=node.r;
                int C=node.c;
            
                for(int i=0; i<4; i++){
                   int newR=R+dr[i];
                   int newC=C+dc[i];
                   if(newR>=0 && newR<n && newC>=0 && newC<m && !vis[newR][newC] && grid[newR][newC]==1){
                      q.offer(new Pair(newR,newC));
                      vis[newR][newC]=true;
                      fresh--;
                      flag=true;
                    }
                
                }
            }
            if(flag) time++;
            
        }
        return (fresh==0)? time : -1;
    }
}