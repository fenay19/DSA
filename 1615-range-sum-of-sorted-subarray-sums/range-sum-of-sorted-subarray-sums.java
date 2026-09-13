import java.util.PriorityQueue;

class Solution {

    static class Node {
        long sum;
        int index;

        Node(long sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1_000_000_007;

        PriorityQueue<Node> mh = new PriorityQueue<>(
            (a, b) -> Long.compare(a.sum, b.sum)
        );

        // Initially add all single-element subarrays
        for (int i = 0; i < n; i++) {
            mh.offer(new Node(nums[i], i));
        }

        long res = 0;

        for (int i = 0; i < right; i++) {
            Node curr = mh.poll();

            long sum = curr.sum;
            int ind = curr.index;

            // i is zero-based
            if (i >= left - 1) {
                res = (res + sum) % MOD;
            }

            // Extend the popped subarray
            if (ind + 1 < n) {
                long nextsum = sum + nums[ind + 1];

                mh.offer(new Node(nextsum, ind + 1));
            }
        }

        return (int) res;
    }
}