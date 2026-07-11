class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int i = 0;
        while (i < nums.length) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)) {
                result += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            i++;
        }
        return result;
    }
}