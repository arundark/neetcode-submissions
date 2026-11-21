class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0)
            return null;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(0, nums, list);

        return result;
    }

    public void dfs(int length, int[] nums, List<Integer> list) {
        if (length == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[length]);
        dfs(length + 1, nums, list);

        list.remove(list.size() - 1);

        while (length + 1 < nums.length && nums[length] == nums[length + 1]) {
            length++;
        }

        dfs(length + 1, nums, list);
    }
}
