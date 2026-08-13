class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        // Best money we can rob up to the previous-previous house
        int maxRobbedTwoHousesAgo = nums[0];

        // Best money we can rob up to the previous house
        int maxRobbedPreviousHouse = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = maxRobbedPreviousHouse;

            // Either:
            // 1. Rob current house + best from two houses ago
            // 2. Skip current house and keep previous best
            maxRobbedPreviousHouse =
                Math.max(maxRobbedTwoHousesAgo + nums[i], maxRobbedPreviousHouse);

            maxRobbedTwoHousesAgo = temp;
        }

        return maxRobbedPreviousHouse;
    }
}