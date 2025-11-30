class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        for(int i=1;i<n;i++){
             nums[i]+=nums[i-1];
        }
        HashMap<Integer,Integer> remCount=new HashMap<>();
        remCount.put(0,1);
        int ans=0;
        for(int i=0;i<n;i++){
            int rem=nums[i]%k;
            if(rem < 0) rem += k;
            if(remCount.containsKey(rem)){
                ans+=remCount.get(rem);
                
            }
            remCount.put(rem, remCount.getOrDefault(rem, 0) + 1);

        }
        return ans;




        // for(int i=1;i<n;i++){
        //     nums[i]+=nums[i-1];
        // }
        // int ans=0;
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         int sum= (i==0)? nums[j]:nums[j]-nums[i-1];
        //         if(sum%k==0) ans++;
        //     }
        // }
        // return ans;
    }
}