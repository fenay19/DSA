class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totsum=0;
        for(int i=0;i<nums.length;i++){
            totsum+=nums[i];
        }
  if(Math.abs(target)>totsum) return 0;
      
        if((totsum+target)%2!=0){
            return 0;
        }
          int fsum=(totsum+target)/2;


        return perfectSum(nums,fsum);
    }
        public int perfectSum(int[] nums, int k) {
        // code here
        
        int n = nums.length;

        int[][] dp = new int[n + 1][k + 1];

        dp[n][0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= k; j++) {

                if (nums[i] > j) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j - nums[i]] + dp[i + 1][j];
                }
            }
        }

        return dp[0][k];
    }
}