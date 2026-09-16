class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length()][text2.length()];

        for (int i = 0; i < text1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(text1, text2, 0, 0, dp);
    }

    int solve(String text1, String text2, int i, int j, int[][] dp) {

        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] =
                1 + solve(text1, text2, i + 1, j + 1, dp);
        }

        int c1 = solve(text1, text2, i + 1, j, dp);
        int c2 = solve(text1, text2, i, j + 1, dp);

        return dp[i][j] = Math.max(c1, c2);
    }
}