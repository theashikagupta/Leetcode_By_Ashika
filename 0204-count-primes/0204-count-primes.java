// class Solution {
//     public int countPrimes(int n) {
//         int countPrime = 0;

//         for (int i = 2; i < n; i++) {
//             int count = 0; 
//             for (int j = 1; j <= Math.sqrt(i); j++) {
//                 if (i % j == 0) {
//                     count++;
//                     if (j != i / j) { 
//                         count++;
//                     }
//                 }
//             }
//             if (count == 2) { 
//                 countPrime++;
//             }
//         }

//         return countPrime;
//     }
// }


class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) count++;
        }
        return count;
    }
}

