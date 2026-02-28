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
     List<Integer>res=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
          
       rightwithlevel(root,0);
       return res;
    }

    public void rightwithlevel(TreeNode root,int level){
       
        if(root==null) return;
         if(level==res.size()){
            res.add(root.val);
         }
        rightwithlevel(root.right,level+1);
        rightwithlevel(root.left,level+1);
 
    }
}