class Solution {

    public int rob(int[] nums) {

        int[][] dp = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return robber(nums, 0, nums.length, 1, dp);
    }

    int robber(int[] num, int i, int n, int free, int[][] dp) {

        if (i == n) {
            return 0;
        }

        if (dp[i][free] != -1) {
            return dp[i][free];
        }

        if (free == 0) {
            return dp[i][free] = robber(num, i + 1, n, 1, dp);
        }

        int c1 = num[i] + robber(num, i + 1, n, 0, dp);

        int c2 = robber(num, i + 1, n, 1, dp);

        return dp[i][free] = Math.max(c1, c2);
    }
}