class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int ans = 1;
        int len = 1;
        int prev = 0;

        for (int i = 1; i < arr.length; i++) {

            int curr;

            if (arr[i] > arr[i - 1])
                curr = 1;
            else if (arr[i] < arr[i - 1])
                curr = -1;
            else
                curr = 0;

            if (curr == 0) {
                len = 1;
            }
            else if (curr == -prev) {
                len++;
            }
            else {
                len = 2;
            }

            prev = curr;
            ans = Math.max(ans, len);
        }

        return ans;
    }
}