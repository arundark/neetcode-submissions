class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        int[] arr = new int[nums.length];

        int previous2 = nums[0];
        int previous1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int temp = previous1;
            previous1 = Math.max((previous2 + nums[i]), previous1);
            previous2 = temp;
        }

        return previous1;
    }
}
