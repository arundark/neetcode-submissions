class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0];
        int currentMax = 0;
        int globalMin = nums[0];
        int currentMin = 0;
        int total = 0;

        for (int num : nums) {
            total += num;

            currentMax += num;
            globalMax = Math.max(currentMax, globalMax);

            if (currentMax < 0)
                currentMax = 0;

            currentMin = Math.min(currentMin + num, num);
            globalMin = Math.min(currentMin, globalMin);
        }
        if (globalMax < 0)
            return globalMax;
        return Math.max(globalMax, total - globalMin);
    }
}