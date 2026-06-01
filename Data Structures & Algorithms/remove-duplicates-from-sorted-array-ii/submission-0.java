class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int current = nums[0];
        int count = 0;
        int n = nums.length;

        while (j < n) {
            if (nums[j] == current) {
                count++;
            } else {
                current = nums[j];
                count = 1;
            }
            
            if (count <= 2) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}