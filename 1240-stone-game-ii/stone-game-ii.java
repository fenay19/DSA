
class Solution {
    int n;
    int[][][] dp;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[2][n][n + 1];

        for (int a = 0; a < 2; a++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[a][i], -1);
            }
        }

        return dfs(piles, true, 0, 1);
    }

    int dfs(int[] piles, boolean alice, int i, int M) {
        if (i == n) {
            return 0;
        }

        int turn = alice ? 1 : 0;

        if (dp[turn][i][M] != -1) {
            return dp[turn][i][M];
        }

        int res = alice ? 0 : Integer.MAX_VALUE;
        int total = 0;

        for (int X = 1; X <= 2 * M && i + X <= n; X++) {
            total += piles[i + X - 1];

            int next = dfs(
                piles,
                !alice,
                i + X,
                Math.max(M, X)
            );

            if (alice) {
                res = Math.max(res, total + next);
            } else {
                res = Math.min(res, next);
            }
        }

        dp[turn][i][M] = res;
        return res;
    }
}
