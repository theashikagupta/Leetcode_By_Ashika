class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n=nums.length-2;
        int XOR=0;
        for(int x:nums){
            XOR^=x;
        }
        for(int x=0;x<n;x++){
            XOR^=x;
        }
        int trailingZeroCount = Integer.numberOfTrailingZeros(XOR);
        int mask=1 << trailingZeroCount;
        int G1=0 ,G2=0;
        for(int x:nums){
            if((x & mask)==0){
                G1^=x;
            }else{
                G2^=x;
            }
        }
        forint x=0;x<n;x++){
            if((x & mask)==0){
                G1^=x;
            }else{
                G2^=x;
            }
        }
        return new int[]{G1, G2};
    }
}