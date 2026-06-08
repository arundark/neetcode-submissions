class Solution {
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == val){
                fast++;
            }
            else{
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }
        }
        return slow;
    }
}