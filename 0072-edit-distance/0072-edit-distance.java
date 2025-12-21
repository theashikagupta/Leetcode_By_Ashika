class Solution {
    public int minDistance(String word1, String word2) {
        int[][] t=new int[501][501];
        for(int i=0;i<501;i++){
            Arrays.fill(t[i],-1);
        }
        return solve(word1,word2,0,0,t);
    }
    public int solve(String w1, String w2,int i,int j,int[][] t){
        int m=w1.length();
        int n=w2.length();
        
        if(i==m) return n-j;
        if(j==n) return m-i;
        if(t[i][j]!=-1) return t[i][j];

        if(w1.charAt(i)==w2.charAt(j)){
           t[i][j]=solve(w1,w2,i+1,j+1,t);
        }
        else{
             int insert=1+solve(w1,w2,i,j+1,t);
             int delete=1+solve(w1,w2,i+1,j,t);
             int replace=1+solve(w1,w2,i+1,j+1,t);
            t[i][j]=Math.min(insert,(Math.min(delete,replace)));
        }
    return t[i][j];
    }
}

