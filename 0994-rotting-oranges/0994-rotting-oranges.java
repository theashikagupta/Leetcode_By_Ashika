class Solution {
    static int rowL, colL ;
    int maxTime=0;
    static int [] dr={-1,1,0,0};
    static int [] dc={0,0,-1,1};
    static class Pair{
        int r;
        int c;
        int t;
        public Pair(int r, int c , int t){
                this.r=r;
                this.c=c;
                this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        rowL=grid.length;
        colL=grid[0].length;
        int fresh=0;
        // boolean[][] vis=new boolean [rLen][cLen];
        
        Queue<Pair> q=new LinkedList<>();

        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
     

        while(!q.isEmpty()){
            Pair curr=q.poll();
            int row=curr.r;
            int col=curr.c;
            int time=curr.t;

            maxTime=Math.max(maxTime, time);

            for(int i=0;i<4;i++){
                int nRow=row+dr[i];
                int nCol=col+dc[i];

                if(nRow>=0 && nCol>=0 && nRow<rowL && nCol<colL && grid[nRow][nCol]==1){
                    grid[nRow][nCol]=2;
                    fresh--;
                    q.offer(new Pair(nRow,nCol,time+1));
                }
            }
        }
        return (fresh==0)? maxTime:-1;

    }
}