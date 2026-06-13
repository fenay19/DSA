class Solution {
    public int countPaths(int n, int[][] roads) {

        int mod = 1000000007;

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        int[] ways = new int[n];

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));

        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty()) {

            long[] curr = pq.poll();

            long d = curr[0];
            int node = (int)curr[1];

            if(d > dist[node]) continue;

            for(int[] neigh : adj.get(node)) {

                int adjNode = neigh[0];
                int wt = neigh[1];

                if(d + wt < dist[adjNode]) {

                    dist[adjNode] = d + wt;

                    ways[adjNode] = ways[node];

                    pq.offer(new long[]{dist[adjNode], adjNode});
                }
                else if(d + wt == dist[adjNode]) {

                    ways[adjNode] =
                        (int)((ways[adjNode] + (long)ways[node]) % mod);
                }
            }
        }

        return ways[n - 1];
    }
}