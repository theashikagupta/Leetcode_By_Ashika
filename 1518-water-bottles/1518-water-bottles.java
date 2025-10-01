class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=numBottles;
        int no_bottles=numBottles;
        while(no_bottles>=numExchange){
            int quo=(no_bottles/numExchange);
            int rem=(no_bottles%numExchange);
            ans+=quo;
            no_bottles=quo+rem;
        }
        return ans;
    }
}