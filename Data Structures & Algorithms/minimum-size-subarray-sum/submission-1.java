class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int total = 0;

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];

            while (total >= target) {
                minLength = Math.min(minLength, right - left + 1);
                total -= nums[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}