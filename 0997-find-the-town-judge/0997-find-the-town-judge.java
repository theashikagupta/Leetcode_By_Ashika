class Solution {
    public int findJudge(int n, int[][] trust) {
     
        int[] degree=new int[n+1];
        if(n==1) return 1;
        
        for(int i=0; i<trust.length; i++){
            int a=trust[i][0];
            int b=trust[i][1];
            degree[a]--;
            degree[b]++;
        }

        for(int i=1;i<=n;i++){
            if(degree[i]==n-1){
                return i;
            }
        }
    return -1;
    }
}