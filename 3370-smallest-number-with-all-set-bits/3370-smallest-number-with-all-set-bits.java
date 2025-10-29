class Solution {
   
    public int smallestNumber(int n) {
        // //O(n)
        // int x=n;
        // while((x & (x + 1))!=0){
        //     x++;
        // }
        // return x;

        //O(logn)
        // int res=1;
        // while(res<n){
        //     res=2*res+1;
        // }
        // return res;

       
        int bits = (int)(Math.log(n) / Math.log(2)) + 1;  // number of bits needed
        return (1 << bits) - 1;  // bitmask with all bits = 1
    }
}
