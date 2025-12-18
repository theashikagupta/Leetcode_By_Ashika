class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result=new ArrayList<>();
        int[] t=new int[nums.length];
        Arrays.fill(t,1);
        int[] prev=new int[nums.length];
        Arrays.fill(prev,-1);
        
        int last_idx=0;
        int maxL=1;


       for(int i=1;i<nums.length;i++)
       {
        for(int j=0;j<i;j++)
        {
           if(nums[i]%nums[j]==0)
           {
            if(t[j]+1>t[i])
            {
                t[i]=t[j]+1;
                prev[i]=j;
               
            }
            if(maxL<t[i]){
                maxL=t[i];
                last_idx=i;
            }
           }
        }
        }

        while(last_idx>=0){
           result.add(nums[last_idx]);
           last_idx=prev[last_idx];
        }
       
       return result;
    }
}