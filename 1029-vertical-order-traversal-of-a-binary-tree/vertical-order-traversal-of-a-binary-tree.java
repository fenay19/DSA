/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // vertical -> level -> minHeap of node values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // BFS queue
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();
            TreeNode node = current.node;
            int vertical = current.vertical;
            int level = current.level;

            // Create vertical entry if absent
            map.putIfAbsent(vertical, new TreeMap<>());

            // Create level entry if absent
            map.get(vertical).putIfAbsent(level, new PriorityQueue<>());

            // Add node value
            map.get(vertical).get(level).offer(node.val);

            // Add left child
            if (node.left != null) {
                queue.offer(new Pair(node.left, vertical - 1, level + 1));
            }

            // Add right child
            if (node.right != null) {
                queue.offer(new Pair(node.right, vertical + 1, level + 1));
            }
        }

        // Build final answer
        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> pq : levels.values()) {
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }

            result.add(column);
        }

        return result;
    }

    static class Pair{
        TreeNode node;
        int vertical;
        int level;
        Pair(TreeNode n,int v,int l){
            node=n;
            vertical=v;
            level=l;

        }
    }
}