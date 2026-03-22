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
    
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        // paths starting from current node
        int fromRoot = countFromNode(root, targetSum);

        // paths from left subtree + right subtree
        int left = pathSum(root.left, targetSum);
        int right = pathSum(root.right, targetSum);

        return fromRoot + left + right;
    }

    // count paths starting from THIS node
    public int countFromNode(TreeNode node, long target) {
        if (node == null) return 0;

        int count = 0;

        if (node.val == target) count++;

        count += countFromNode(node.left, target - node.val);
        count += countFromNode(node.right, target - node.val);

        return count;
    }
}