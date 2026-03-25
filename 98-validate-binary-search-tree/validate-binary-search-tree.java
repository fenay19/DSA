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
    TreeNode prev=null;
    boolean ans=true;
    public boolean isValidBST(TreeNode root) {
      return  helper(root);
    }
    public boolean helper(TreeNode root){
        if(root==null) return true;

      helper(root.left);

if(prev==null) {
    prev=root;
}
else if(prev!=null && prev.val>=root.val){
ans=false;

}
prev=root;


helper(root.right);


return ans;
    }
}