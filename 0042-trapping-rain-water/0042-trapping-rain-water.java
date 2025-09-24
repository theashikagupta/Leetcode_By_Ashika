class Solution {
    public int trap(int[] height) {
        int n=height.length;
        //create left max boundary-array
        int[] left=new int [n];
        left[0]=height[0];
        for(int i=1;i<n;i++){
            left[i]=Math.max(height[i],left[i-1]);
        }
        //create right max boundary-array
        int[] right=new int [n];
        right[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(height[i],right[i+1]);
        }
        //for loop
        int trappedWater=0;
        for(int i=0;i<n;i++){
             //water level =min(left,right)
             int waterlevel=Math.min(left[i],right[i]);
             //trapped water=water level-height[i]
             trappedWater += waterlevel-height[i];

        }
       
        return trappedWater;

       
        // int n = height.length;
        // int ans = 0;

        // for (int i = 0; i < n; i++) {
        //     int left = 0, right = 0;

        //     // find left max for current i
        //     for (int j = 0; j <= i; j++) {
        //         left = Math.max(left, height[j]);
        //     }

        //     // find right max for current i
        //     for (int k = i; k < n; k++) {
        //         right = Math.max(right, height[k]);
        //     }

        //     int minHeight = Math.min(left, right);
        //     ans += minHeight - height[i];
        // }

        // return ans;
    }
}
