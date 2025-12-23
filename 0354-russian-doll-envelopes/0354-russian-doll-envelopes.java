class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        // 1️⃣ Sort envelopes
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];   // width ↑
            return b[1] - a[1];                    // height ↓ (important)
        });

        int n = envelopes.length;
        int[] heights = new int[n];

        // 2️⃣ Store heights
        for (int i = 0; i < n; i++) {
            heights[i] = envelopes[i][1];
        }

        // 3️⃣ Apply LIS on heights
        return lis(heights);
    }

    // LIS using binary search (O(n log n))
    public int lis(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int num : nums) {
            if (temp.isEmpty() || num > temp.get(temp.size() - 1)) {
                temp.add(num);
            } else {
                int idx = lowerBound(temp, num);
                temp.set(idx, num);
            }
        }
        return temp.size();
    }

    // lower bound
    public int lowerBound(ArrayList<Integer> temp, int target) {
        int low = 0, high = temp.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (temp.get(mid) >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
