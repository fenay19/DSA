class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        
        // dp[i][j][k] = max coins till (i,j) with k neutralizations used
        int[][][] dp = new int[m][n][3];
        
        // Initialize with very small values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        
        // Base case (0,0)
        if (coins[0][0] >= 0) {
            dp[0][0][0] = coins[0][0];
        } else {
            dp[0][0][0] = coins[0][0];     // don't neutralize
            dp[0][0][1] = 0;              // neutralize
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;
                    
                    // Move Down
                    if (i + 1 < m) {
                        int val = coins[i + 1][j];
                        
                        // Without neutralizing
                        dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k] + val);
                        
                        // With neutralizing (if negative)
                        if (val < 0 && k < 2) {
                            dp[i + 1][j][k + 1] = Math.max(dp[i + 1][j][k + 1], dp[i][j][k]);
                        }
                    }
                    
                    // Move Right
                    if (j + 1 < n) {
                        int val = coins[i][j + 1];
                        
                        // Without neutralizing
                        dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i][j][k] + val);
                        
                        // With neutralizing (if negative)
                        if (val < 0 && k < 2) {
                            dp[i][j + 1][k + 1] = Math.max(dp[i][j + 1][k + 1], dp[i][j][k]);
                        }
                    }
                }
            }
        }
        
        // Final answer: max among 0,1,2 neutralizations
        int res = Integer.MIN_VALUE;
        for (int k = 0; k < 3; k++) {
            res = Math.max(res, dp[m - 1][n - 1][k]);
        }
        
        return res;
    }
}