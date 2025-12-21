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
       
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    t[i][j]=1 + t[i+1][j+1];
                }
                else{
                    t[i][j]=Math.max(t[i+1][j],t[i][j+1]);
                }
            }
        }
        return t[0][0];
    }
}