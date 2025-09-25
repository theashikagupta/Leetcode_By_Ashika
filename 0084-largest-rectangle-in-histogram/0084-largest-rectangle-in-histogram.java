class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int currH=(i==heights.length)? 0: heights[i];
            while(!st.isEmpty() && heights[st.peek()]>currH){
                int h=heights[st.pop()];
                int width=st.isEmpty()?i: i-st.peek()-1;
                maxArea=Math.min(maxArea,h*width);
            }
          
        
        st.push(i);
        }
        return maxArea;
    }
}