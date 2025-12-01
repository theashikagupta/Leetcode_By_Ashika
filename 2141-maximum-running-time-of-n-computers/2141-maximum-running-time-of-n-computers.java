class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long l = 0;
        long r = sum / n;
        long ans = 0;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (possible(batteries, mid, n)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private boolean possible(int[] batteries, long mid, int n) {
        long target = n * mid; // total minutes required

        for (int b : batteries) {
            target -= Math.min((long)b, mid);
            if (target <= 0) return true; // enough battery
        }
        return target <= 0;
    }
}
