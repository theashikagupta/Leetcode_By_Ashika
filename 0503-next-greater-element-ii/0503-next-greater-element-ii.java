class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currIndex = i % n;
            
            // stack se chhote elements hatao
            while (!s.isEmpty() && nums[s.peek()] <= nums[currIndex]) {
                s.pop();
            }
            
            // agar stack khali hai → next greater nahi mila
            res[currIndex] = s.isEmpty() ? -1 : nums[s.peek()];
            
            // current index ko stack me daal do
            s.push(currIndex);
        }
        
        return res;
    }
}
