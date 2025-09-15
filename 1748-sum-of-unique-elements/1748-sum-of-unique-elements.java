class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        int sum=0;
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(int i=0;i<nums.length;i++){
            if(freq.get(nums[i])==1){
                sum+=nums[i];
            }

        }
        return sum;
    }
}