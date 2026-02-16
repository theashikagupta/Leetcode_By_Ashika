class Solution {
    static int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();
        int visited[][]=new int [m][n];
        if(bfs(0,0,visited,grid,health)){
            return true;
        }
        return false;
    }

    public boolean bfs(int row,int col,int visited[][],List<List<Integer>> grid , int health){
        PriorityQueue<int []> q=new PriorityQueue<>((a,b)->(b[2]-a[2]));

        if(grid.get(row).get(col)==1){
            health=health-1;
            if(health<=0){
                return false;
            }
        }

        q.offer(new int []{0,0,health});
        visited[row][col]=1;

        while(!q.isEmpty()){
            int curr[]=q.poll();
            int r=curr[0];
            int c=curr[1];
            int h=curr[2];

            if(r==grid.size()-1 && c==grid.get(0).size()-1 && h>0){
                return true;
            }

    
            for(int i=0;i<4;i++){
                int dr=r + dir[i][0];
                int dc=c + dir[i][1];


                if(dr>=0 && dr<grid.size() && dc>=0 && dc<grid.get(0).size() && visited[dr][dc]==0 && h>0){
                    int mh=h;
                    if(grid.get(dr).get(dc)==1){
                        mh=h-1;
                    }
                    if(mh>0){
                        visited[dr][dc]=1;
                        q.offer(new int []{dr,dc,mh});
                    }
                }
            }
        }

        return false;
    }
}