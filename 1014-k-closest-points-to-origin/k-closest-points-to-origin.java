import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        // Max heap based on distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            int dist = x * x + y * y;

            // store {distance, index}
            maxHeap.offer(new int[]{dist, i});

            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove farthest
            }
        }

        int[][] res = new int[k][2];
        int i = 0;

        while (!maxHeap.isEmpty()) {
            int[] ele = maxHeap.poll();
            int idx = ele[1];

            res[i][0] = points[idx][0];
            res[i][1] = points[idx][1];
            i++;
        }

        return res;
    }
}
