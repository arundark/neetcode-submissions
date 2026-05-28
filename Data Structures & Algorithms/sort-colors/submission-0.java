class Solution {
    public void sortColors(int[] nums) {
        int[] counts = {0, 0, 0};

        for (int num : nums) {
            counts[num] += 1;
        }

        int n = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[n] = i;
                n++;
            }
        }
    }
}