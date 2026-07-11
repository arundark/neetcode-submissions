class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int left = 1;

        // prefixSum
        for (int i = 0; i < nums.length; i++) {
            result[i] = left;
            left *= nums[i];
        }

        // suffixSum
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = right * result[i];
            right *= nums[i];
        }

        return result;
    }
}
