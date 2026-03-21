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
    boolean res=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {

        sum(root,0,targetSum);
        return res;
        
    }
    public void sum(TreeNode root,int sum,int target){
if(root==null) return;

sum+=root.val;

if(root.left==null && root.right==null){
    if(sum==target) res=true;
    return;
}

sum(root.left,sum,target);
sum(root.right,sum,target);



    }
}