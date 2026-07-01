class Solution {
    public int longestPalindromeSubseq(String s) {
         String rev = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s,rev);
    }
  
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();

        int[][] t = new int[n+1][m+1];

       
        for(int i=1; i<=n; i++){
          for(int j=1; j<=m; j++){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
              t[i][j]=1+t[i-1][j-1];
            }else{
                t[i][j]=Math.max(t[i][j-1],t[i-1][j]);
            }
          }
        }
        return t[n][m];
    }

}