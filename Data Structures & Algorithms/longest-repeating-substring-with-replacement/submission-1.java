class Solution {
    public int characterReplacement(String s, int k) {
         HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        int maxValue = 0;

        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            maxValue = Math.max(maxValue, map.get(s.charAt(right)));

            if ((right - left + 1) - maxValue > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            maxLength = Math.max(right - left + 1, maxLength);
        }

        return maxLength;
    }
}
