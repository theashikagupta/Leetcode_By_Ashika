class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] t = new int[1001][1001];

        for (int i = 0; i < 1001; i++) {
           Arrays.fill(t[i], -1);
        }

        return solve(text1,text2,0,0,t);
        
        
    }
    public int solve(String s1, String s2, int i,int j,int[][] t){
        int n=s1.length();
        int m=s2.length();

        if(i>=n || j>=m) return 0;
        if(t[i][j]!=-1) return t[i][j];
        if(s1.charAt(i)==s2.charAt(j)) {
           return t[i][j]=1+solve(s1,s2,i+1,j+1,t);
        }
        

        return t[i][j]=Math.max(
            solve(s1,s2,i,j+1,t),
            solve(s1,s2,i+1,j,t)
        );
    }
}