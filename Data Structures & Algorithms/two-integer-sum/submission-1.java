class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                int j = map.get(key);

                return new int[] {j, i};

            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}
