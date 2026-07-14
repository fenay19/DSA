class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int h = matrix[n - 1][n - 1];

        while (l <= h) {
            int m = l + (h - l) / 2;

            int cnt = countw(matrix, m);

            if (cnt < k) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l;
    }

    int countw(int[][] matrix, int t) {
        int n = matrix.length;
        int r = n - 1;
        int c = 0;
        int cnt = 0;

        while (r >= 0 && c < n) {
            if (matrix[r][c] <= t) {
                cnt += r + 1;
                c++;
            } else {
                r--;
            }
        }

        return cnt;
    }
}