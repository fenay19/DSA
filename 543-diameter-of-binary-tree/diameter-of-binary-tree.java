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
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxs(root);
        return res;
    }

    public int maxs(TreeNode root){
        if(root==null) return 0;

        int left=maxs(root.left);
        int right=maxs(root.right);


        res=Math.max(res,left+right);

        return 1+Math.max(left,right);
    }
}