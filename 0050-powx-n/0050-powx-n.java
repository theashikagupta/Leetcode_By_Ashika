class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;

        // handle negative power
        long nn = n;
        if (nn < 0) {
            x = 1 / x;
            nn = -nn;
        }

        double half = myPow(x, (int)(nn / 2));

        if (nn % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
