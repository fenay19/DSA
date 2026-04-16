import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Step 1: Map value -> indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();

        // Step 2: Process queries
        for (int idx : queries) {
            List<Integer> list = map.get(nums[idx]);

            // If only one occurrence
            if (list.size() == 1) {
                res.add(-1);
                continue;
            }

            // Find position of idx in list
            int pos = Collections.binarySearch(list, idx);

            int m = list.size();

            // neighbors (circular)
            int prev = list.get((pos - 1 + m) % m);
            int next = list.get((pos + 1) % m);

            // Compute circular distance
            int distPrev = Math.min(Math.abs(idx - prev), n - Math.abs(idx - prev));
            int distNext = Math.min(Math.abs(idx - next), n - Math.abs(idx - next));

            res.add(Math.min(distPrev, distNext));
        }

        return res;
    }
}