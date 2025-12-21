class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();

        int[][] t = new int[1001][1001];

        for (int i = 0; i < n+1; i++) {
           t[i][0]=0;
        }
        for (int j = 0; j < m+1; j++) {
           t[0][j]=0;
        }
       
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    t[i][j]=1 + t[i-1][j-1];
                }
                else{
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[n][m];
    }
}