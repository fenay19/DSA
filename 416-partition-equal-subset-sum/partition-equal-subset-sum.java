class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        if(sum%2!=0){
            return false;
        }
        return isSubsetSum(nums,sum/2);
    }
     static Boolean isSubsetSum(int arr[], int sum) {

        int n = arr.length;
        Boolean[][] dp = new Boolean[n + 1][sum + 1];

        return sub(arr, n, 0, sum, dp);
    }

    static boolean sub(int[] arr, int n, int i, int sum, Boolean[][] dp) {

        if (sum == 0) return true;
        if (i == n) return false;

        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        if (arr[i] > sum) {
            return dp[i][sum] = sub(arr, n, i + 1, sum, dp);
        }

        boolean c1 = sub(arr, n, i + 1, sum - arr[i], dp);
        boolean c2 = sub(arr, n, i + 1, sum, dp);

        return dp[i][sum] = c1 || c2;
    }
}