class Solution {
    public int swimInWater(int[][] heights) {
           int n = heights.length;
        int m = heights[0].length;

        int[][] res = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, -1, 1};

        res[0][0] = heights[0][0];

        pq.offer(new int[]{heights[0][0], 0, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int dist = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (dist > res[r][c]) {
                continue;
            }

            for (int k = 0; k < 4; k++) {

                int r1 = r + x[k];
                int c1 = c + y[k];

                if (r1 >= 0 && r1 < n && c1 >= 0 && c1 < m) {

                 

                    int newdist = Math.max(heights[r1][c1], dist);

                    if (newdist < res[r1][c1]) {

                        res[r1][c1] = newdist;

                        pq.offer(new int[]{newdist, r1, c1});
                    }
                }
            }
        }

        return res[n - 1][m - 1];
    }
}