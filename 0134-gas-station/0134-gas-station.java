class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int g=gas.length;
        int c=cost.length;
        int gSum=0, cSum=0; 
        int total=0; 
        int result=0;

        for(int i=0; i<g; i++){
            gSum+=gas[i];
        }
        for(int i=0; i<c; i++){
            cSum+=cost[i];
        }
        if(gSum<cSum) return -1;
        
        int i=0;
        while(i<g){
            total=total+gas[i]-cost[i];
            if(total<0){
                total=0;
                result=i+1;      
            }
           
            i++;

        }
        return result;
    }
}