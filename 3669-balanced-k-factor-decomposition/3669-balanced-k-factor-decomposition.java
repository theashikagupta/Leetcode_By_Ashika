// TC: O((√n)^k) worst case
// SC: O(k)

class Solution {
    // Backtracking helper to generate factor splits
    private void findFactors(int remaining, int slotsLeft,
                             List<Integer> path, List<Integer> bestResult) {
        // Base case: used all slots
        if (slotsLeft == 0) {
            if (remaining == 1 && !path.isEmpty()) {
                int currentDiff = Collections.max(path) - Collections.min(path);
                if (bestResult.isEmpty() ||
                    currentDiff < (Collections.max(bestResult) - Collections.min(bestResult))) {
                    bestResult.clear();
                    bestResult.addAll(path);
                }
            }
            return;
        }

        // Try all possible divisors
        for (int factor = 1; factor <= remaining; factor++) {
            if (remaining % factor == 0) {
                path.add(factor); // choose
                findFactors(remaining / factor, slotsLeft - 1, path, bestResult);
                path.remove(path.size() - 1); // backtrack
            }
        }
    }

    public int[] minDifference(int n, int k) {
        List<Integer> bestResult = new ArrayList<>();
        findFactors(n, k, new ArrayList<>(), bestResult);

        // Convert list to array
        int[] result = new int[bestResult.size()];
        for (int i = 0; i < bestResult.size(); i++) {
            result[i] = bestResult.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] triplet = sol.minDifference(24, 3);
        System.out.println(Arrays.toString(triplet)); // e.g. [2, 3, 4]
    }
}
