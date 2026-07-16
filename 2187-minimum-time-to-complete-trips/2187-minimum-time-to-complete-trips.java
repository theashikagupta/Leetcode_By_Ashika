class Solution {
    public long minimumTime(int[] time, int totalTrips) {
      //Brute force 
        // int currTime=1; int trip=0;
        
        // while(true){

        //     for(int t: time){
        //         trip+= currTime/t;
        //     }
        //     if(trip>=totalTrips) break;
        //     currTime++;
        // }
        // return currTime;

     //Optimal soln -binary search
        int min=Integer.MAX_VALUE;
        for(int t: time){
            min=Math.min(min,t);
        }
        
        long l=1, r=(long)min*totalTrips;
        while(l<r){
          
            long mid=l+(r-l)/2;
            
            if(possible(mid,totalTrips,time)){
                r=mid;
            }
            else{
                l=mid+1;
            }
            
        }
        return l;

    }

    public boolean possible(long mid, int totalTrips, int[] time){
        long trips=0;
        for(int t: time){
            trips+= mid/t;
        }
        return trips>=totalTrips;
        
    }
}