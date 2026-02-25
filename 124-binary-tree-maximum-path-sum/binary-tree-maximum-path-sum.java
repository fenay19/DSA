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
    int maxi = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max(root);
        return maxi;
    }

    public int max(TreeNode root){
        if(root == null) return 0;

        int lsum=Math.max(0,max(root.left));
        int rsum=Math.max(0,max(root.right));
        maxi=Math.max(maxi,root.val+lsum+rsum);

        return root.val+Math.max(lsum,rsum);
    }
}