class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();

        int[] dp = new int[col + 1];

        for (int i = 1; i <= row; i++) {
            int[] curr = new int[col + 1];
            for (int j = 1; j <= col; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + dp[j - 1];
                } else {
                    curr[j] = Math.max(dp[j], curr[j - 1]);
                }
            }
            dp = curr;
        }

        return dp[col];
    }
}
