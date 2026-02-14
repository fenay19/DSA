class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        // Create DP array for 101 rows (0 to 100)
        double[][] dp = new double[101][101];
        
        // Pour into the top glass
        dp[0][0] = poured;
        
        // Fill the tower row by row
        for (int row = 0; row < 100; row++) {
            for (int glass = 0; glass <= row; glass++) {
                
                // If overflow exists
                if (dp[row][glass] > 1) {
                    
                    double overflow = dp[row][glass] - 1;
                    
                    // Split overflow equally
                    dp[row + 1][glass] += overflow / 2.0;
                    dp[row + 1][glass + 1] += overflow / 2.0;
                    
                    // Current glass can only hold 1
                    dp[row][glass] = 1;
                }
            }
        }
        
        // Glass can contain maximum 1
        return Math.min(1, dp[query_row][query_glass]);
    }
}