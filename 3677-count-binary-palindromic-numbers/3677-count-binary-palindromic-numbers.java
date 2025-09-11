class Solution {
    public int countBinaryPalindromes(long n) {
        if(n == 0) return 1;
        int bits = (int)Long.toBinaryString(n).length();
        int total = 1;
        for(int i=1; i<bits; i++){
            int x = (i+1)/2 - 1;
            total += Math.pow(2, x);
        }
        int half = (bits + 1)/2;
        long prefix = (n >> (bits - half));
        String binaryPrefix = Long.toBinaryString(prefix);
        String str;
        if(bits % 2 == 0){
            str = binaryPrefix + new StringBuilder(binaryPrefix.substring(0, binaryPrefix.length())).reverse();
        } else {
            str = binaryPrefix + new StringBuilder(binaryPrefix.substring(0, binaryPrefix.length()-1)).reverse();
        }
        Long num = Long.parseLong(str, 2);
        total += prefix - (long)Math.pow(2, half - 1);
        if(num <= n) total++;
        return total;
    }
}

// class Solution {

//     // Count number of bits in n
//     public int findBits(long n) {
//         int bits = 0;
//         while (n > 0) {
//             bits++;
//             n /= 2;
//         }
//         return bits;
//     }

//     // Build palindrome from left half
//     public long makePalindrome(long num, int len) {
//         long res = num;
//         long temp = num;

//         // If odd length, skip the middle bit in mirroring
//         if (len % 2 != 0) temp /= 2;

//         while (temp > 0) {
//             long rem = temp % 2;
//             res = res * 2 + rem;
//             temp /= 2;
//         }
//         return res;
//     }

//     // Count binary palindromes <= n
//     public int countBinaryPalindromes(long n) {
//         int maxLen = findBits(n);
//         int count = 0;

//         // Case 1: all palindromes with length < maxLen
//         for (int len = 1; len <= maxLen; len++) {

//             int half = (len + 1) / 2;

//             long start = 1 << (half - 1);
//             long end = (1 << half) - 1;

//             long left = start, right = end, maxValidNum = -1;

//             while (left <= right) {
//                 long mid = (left + right) / 2;
//                 if (makePalindrome(mid,len) <= n) {
//                     maxValidNum = mid;
//                     left = mid + 1;
//                 } else {
//                    right = mid - 1;
//                 }
//             }      
//             if (maxValidNum != -1) {
//                 count += (maxValidNum - start + 1);
//             }
//         }
//         return count;
//     }
// }
