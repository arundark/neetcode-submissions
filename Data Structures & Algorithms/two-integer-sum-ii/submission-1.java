class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int total = 0;
        int right = numbers.length - 1;

        while (left < right) {
            total = numbers[left] + numbers[right];
            if (total > target) {
                right--;
            } else if (total < target) {
                left++;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }

        return new int[] {};
    }
}
