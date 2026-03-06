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
    public int countNodes(TreeNode root) {
        int cnt=0;
        Queue<TreeNode>q=new LinkedList<>();
        if(root==null) return 0;
         q.offer(root);
        while(!q.isEmpty()){
         int s=q.size();
         TreeNode n=q.poll();
         cnt++;
         

            if(n.left!=null){
                q.offer(n.left);
              
            }
            if(n.right!=null){
                q.offer(n.right);
             
            }
        


        }
        return cnt;
    }
}