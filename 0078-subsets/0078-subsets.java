class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int index, int[] nums,
                           List<Integer> curr, List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // include nums[index]
        curr.add(nums[index]);
        backtrack(index + 1, nums, curr, result);
        curr.remove(curr.size() - 1);

        // exclude nums[index]
        backtrack(index + 1, nums, curr, result);
    }
}