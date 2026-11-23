class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0)
            return false;

        int target = totalSum / 2;

        return dfs(0, target, nums);
    }

    public boolean dfs(int i, int target, int[] nums) {
        if (target == 0)
            return true;

        if (i >= nums.length || target < 0)
            return false;

        if (dfs(i + 1, target - nums[i], nums)) {
            return true;
        }

        if (dfs(i + 1, target, nums)) {
            return true;
        }

        return false;
    }
}
