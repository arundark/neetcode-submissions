class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            int length = 0;
            if (!set.contains(num - 1)) {
                length = 1;

                while (set.contains(num + length)) {
                    length++;
                }

                result = Math.max(result, length);
            }
        }

        return result;
    }
}
