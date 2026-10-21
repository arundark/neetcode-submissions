class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;

        for (int num : nums) {
            if (num != 1) {
                count = 0;
            } else {
                count++;
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}