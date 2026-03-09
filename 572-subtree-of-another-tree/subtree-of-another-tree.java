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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
     if(root==null) return false;

     if(issame(root,subRoot)){
  return true;
     }
    return isSubtree(root.left,subRoot) ||
     isSubtree(root.right,subRoot);
    }

    public boolean issame(TreeNode a,TreeNode b){
    if(a==null && b==null){
        return true;
    }
    if(a==null || b==null) return false;

    if(a.val!=b.val){
        return false;
    }

  boolean r1=  issame(a.left,b.left);
  boolean r2=  issame(a.right,b.right);
return r1 & r2;
    } 
}