class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
//   Method-1
    // int bottlesDrunk = numBottles;
    // int emptyBottles = numBottles;

    // while (emptyBottles >= numExchange) {
    //     int newFull = emptyBottles / numExchange; // bottles we get by exchange
    //     bottlesDrunk += newFull;
    //     emptyBottles = emptyBottles % numExchange + newFull; // remaining empties + new fulls drank
    // }

    // return bottlesDrunk;
// }

// Method-2   log(n)
    int ans=numBottles;
    while(numBottles>=numExchange){
        numBottles-=numExchange-1;
        numExchange++;
        ans++;
    }
    return ans;

    }
}
