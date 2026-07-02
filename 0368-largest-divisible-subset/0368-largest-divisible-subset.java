class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int[] parent=new int[nums.length];
        Arrays.fill(parent,-1);
        int maxLen=1;
        int lastIdx=0;
        for(int i=1; i<nums.length; i++){
            for(int prev=0; prev<i; prev++){
                if(nums[i]%nums[prev]==0 ){
                    if(dp[prev]+1>dp[i]){
                       dp[i]=dp[prev]+1;
                       parent[i]=prev;
                    }
                }
            }
            if(dp[i]>maxLen){
               maxLen=dp[i];
               lastIdx=i;
            }
        }
        
        List<Integer> res=new ArrayList<>(maxLen);
        while(lastIdx>=0){
            res.add(nums[lastIdx]);
            lastIdx=parent[lastIdx];

        }
       
        Collections.reverse(res);
        return res;


    }
}