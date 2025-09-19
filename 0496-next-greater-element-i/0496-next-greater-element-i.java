class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map<Integer,Integer> map=new HashMap<>();
        // Stack<Integer> s=new Stack<>();
        // int n=nums1.length;
        // int[] res=new int[n];
        // for(int num:nums2){
        //     while(!s.isEmpty() && s.peek()<num){
        //         map.put(s.pop(),num);
        //     }
        //     s.push(num);
        // }
        // for(int i=0;i<n;i++){
        //     res[i]=map.getOrDefault(nums1[i],-1);
        // }
        // return res;

        Stack<Integer> s=new Stack<>();
        int n=nums1.length;
        int[] res=new int[n];
        for(int i=nums2.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<nums2[i]){
                res[i]=s.isEmpty()? s.pop() :-1;
            }
            s.push(nums2[i]);
        }
        return res;
    }
}