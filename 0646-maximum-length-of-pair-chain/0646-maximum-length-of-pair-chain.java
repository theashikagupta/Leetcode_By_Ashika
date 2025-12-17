class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int[] t=new int[1000];
        return solve(pairs,t);
    }
    public int solve(int[][]pairs, int[]t){
        int n=pairs.length;
        int maxL=1;
        Arrays.fill(t,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    t[i]=Math.max(t[i],t[j]+1);
                    maxL=Math.max(maxL,t[i]);
                }
            }
        }
        return maxL;
    }
}