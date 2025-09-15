class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

    for (long i = 2; i <= x / 2; i++) {  
        if (i * i == x || x-i*i==1) return (int) i;
        if (i * i > x) return (int) (i - 1);
    }
    return 1;
    }
}

// class Solution {
//     public int mySqrt(int x) {
//         if (x == 0 || x == 1) return x;

//         for (long i = 1; i <= x; i++) {  
//             if (i * i == x) return (int) i;
//             if (i * i > x) return (int) (i - 1);
//         }
//         return -1;
//     }
// }
