class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;
       
        for(int p:piles){
            high=Math.max(p,high);
        }


        while(low<high){
            int mid=low+(high-low)/2;
            if(possible(piles,mid,h)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    public boolean possible(int[] piles, int mid, int h){
        int hour=0;
        
        for(int p:piles){
            hour+=p/mid;
            if(p%mid!=0){
                hour++;
            }
        }

        return (hour<=h);
    }
}