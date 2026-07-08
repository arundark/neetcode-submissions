class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        char[] chars = s.toCharArray();
        for (int right = 0; right < chars.length; right++) {

            if (set.contains(chars[right])) {
                while (set.contains(chars[right])) {
                    set.remove(chars[left]);
                    left++;
                }
            }

            set.add(chars[right]);
            maxLength = Math.max(right - left + 1, maxLength);
        }

        return maxLength;
    }
}
