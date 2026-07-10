class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        int[][] res = new int[k][2];

        for (int i = 0; i < points.length; i++) {

            int x = points[i][0];
            int y = points[i][1];

            int dist = x * x + y * y;

            pq.offer(new int[]{dist, i});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            int[] curr = pq.poll();
            res[i] = points[curr[1]];
        }

        return res;
    }
}