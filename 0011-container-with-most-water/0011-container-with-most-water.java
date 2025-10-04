class Solution {
    public int maxArea(int[] height) {
        int n=height.length; int maxWater=0;
        int l=0 ; int r=n-1;
            while(l<r){
                int h=Math.min(height[l],height[r]);
                int width=r-l;
                int currWater=width*h;
                maxWater=Math.max(currWater,maxWater);
                if(height[l]<height[r]){
                    l++;
            
                }else{
                    r--;
                }
            }
                
            
        
        return maxWater;
    }
}