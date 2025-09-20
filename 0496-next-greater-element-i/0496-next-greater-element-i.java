class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> s=new Stack<>();
        int n=nums1.length;
        int[] res=new int[n];
        for(int num:nums2){
            while(!s.isEmpty() && s.peek()<num){
                map.put(s.pop(),num);
            }
            s.push(num);
        }
        for(int i=0;i<n;i++){
            res[i]=map.getOrDefault(nums1[i],-1);
        }
        return res;

        
    }
}