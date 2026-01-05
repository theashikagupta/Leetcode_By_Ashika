class Solution {
    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        int[][][] dp=new int[s.length()][2][s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(s,0,1,0,dp);

    }
    public int solve(String s, int idx, int tight, int count,int[][][] dp){
        if(idx==s.length()) return count;
        if (dp[idx][tight][count] != -1)
            return dp[idx][tight][count];
        int lb=0; 
        int ub=(tight==1)? s.charAt(idx)-'0':9;
        int res=0;
        for(int d=lb; d<=ub ; d++){
            int newTight=(tight==1 && d==ub)?1 : 0;
            if(d==1) res+= solve(s,idx+1,newTight,count+1,dp);
            else res+= solve(s,idx+1,newTight,count,dp);
        }
        return  dp[idx][tight][count]=res;
    }
}