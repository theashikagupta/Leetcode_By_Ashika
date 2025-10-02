class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int fullBottles=0;
        int emptyBottles=numBottles;
        int bottlesDrunk=numBottles;
        while(emptyBottles>=numExchange){
            while(emptyBottles>=numExchange){
                emptyBottles=emptyBottles-numExchange*1;
                fullBottles++;
                numExchange++;
            }
             bottlesDrunk+=fullBottles;
             emptyBottles+=fullBottles;
             fullBottles=0;
        }
       
     return bottlesDrunk;
    }
}