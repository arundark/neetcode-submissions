class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            HashMap<Integer, Integer> nextdb = new HashMap<>();

            for (int sum : dp.keySet()) {
                int count = dp.get(sum);

                nextdb.put(sum + num, nextdb.getOrDefault(sum + num, 0) + count);

                nextdb.put(sum - num, nextdb.getOrDefault(sum - num, 0) + count);
            }

            dp = nextdb;
        }

        return dp.getOrDefault(target, 0);
    }
}
