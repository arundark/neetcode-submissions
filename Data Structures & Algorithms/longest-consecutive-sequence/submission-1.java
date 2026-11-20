class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int longestLength = 0;

        for (int num : nums) {
            map.put(num, false);
        }

        for (int num : nums) {
            int length = 1;

            int nextNum = num + 1;
            while (map.containsKey(nextNum) && !map.get(nextNum)) {
                length++;
                map.put(nextNum, true);
                nextNum++;
            }

            int previousNum = num - 1;
            while (map.containsKey(previousNum) && !map.get(previousNum)) {
                length++;
                map.put(previousNum, true);
                previousNum--;
            }

            longestLength = Math.max(longestLength, length);
        }

        return longestLength;
    }
}
