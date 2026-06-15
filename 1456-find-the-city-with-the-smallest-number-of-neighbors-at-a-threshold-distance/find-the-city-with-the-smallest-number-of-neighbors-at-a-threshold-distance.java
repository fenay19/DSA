import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        int minReachable = Integer.MAX_VALUE;
        int answer = -1;

        for (int city = 0; city < n; city++) {

            int reachable = dijkstra(city, adj, n, distanceThreshold);

            if (reachable <= minReachable) {
                minReachable = reachable;
                answer = city;
            }
        }

        return answer;
    }

    private int dijkstra(int src,
                         List<List<int[]>> adj,
                         int n,
                         int threshold) {

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[src] = 0;
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int d = curr[0];
            int node = curr[1];

            if (d > dist[node]) {
                continue;
            }

            for (int[] neighbor : adj.get(node)) {

                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (dist[node] + weight < dist[nextNode]) {

                    dist[nextNode] = dist[node] + weight;

                    pq.offer(new int[]{
                            dist[nextNode],
                            nextNode
                    });
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (i != src && dist[i] <= threshold) {
                count++;
            }
        }

        return count;
    }
}