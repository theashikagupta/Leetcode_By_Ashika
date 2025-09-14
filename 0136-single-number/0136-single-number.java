class Solution {
    public int singleNumber(int[] nums) {
        //Brute Force //TC:O(n) //SC:O(n)

        // HashMap<Integer,Integer> freq=new HashMap<>();
        // for(int num:nums){
        //     freq.put(num, freq.getOrDefault(num, 0) + 1);

        // }
        // for(int num:nums){
        //     if(freq.get(num)==1){
        //         return num;
        //     }
        // }
        // return -1;

        //Optimal  //TC:O(n) //SC:O(1)
        int res=0;
        for(int num:nums){
            res^=num;
        }
        return res;
         

    }
}