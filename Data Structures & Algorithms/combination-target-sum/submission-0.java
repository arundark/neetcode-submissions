class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> array = new ArrayList<>();
        combinationSum(nums, target, 0, array);
        return list;
    }

    public void combinationSum(int[] nums, int target, int i, List<Integer> array) {
        if (target == 0) {
            list.add(new ArrayList<Integer>(array));
            return;
        }

        if (i >= nums.length || target < 0) {
            return;
        }
        array.add(nums[i]);
        combinationSum(nums, target - nums[i], i, array);
        array.remove(array.size() - 1);
        combinationSum(nums, target, i + 1, array);
    }
}
