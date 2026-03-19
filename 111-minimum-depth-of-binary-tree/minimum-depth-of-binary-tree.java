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
    int cnt=0;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
     int depthl=minDepth(root.left);
     int depthr=minDepth(root.right);
     if(depthl==0) return 1+depthr;
     if(depthr==0) return 1+depthl;

     return 1+Math.min(depthl,depthr);

    }
}