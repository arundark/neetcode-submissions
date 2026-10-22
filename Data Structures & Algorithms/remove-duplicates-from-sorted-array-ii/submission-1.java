class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        int current = nums[0];
        int count = 0;
        int n = nums.length;

        while (fast < n) {
            if (nums[fast] == current) {
                count++;
            } else {
                current = nums[fast];
                count = 1;
            }
            
            if (count <= 2) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}