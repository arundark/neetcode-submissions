class Solution {
    // Brute force time 2^n and space n
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0)
            return false;

        int target = totalSum / 2;

        memo = new Boolean[nums.length][target+1];

        return dfs(0, target, nums);
    }

    public boolean dfs(int i, int target, int[] nums) {
        if (target == 0)
            return true;

        if (i >= nums.length || target < 0)
            return false;

        if (memo[i][target] != null)
            return memo[i][target];

        memo[i][target] = dfs(i + 1, target - nums[i], nums) || dfs(i + 1, target, nums);

        return memo[i][target];
    }
}
