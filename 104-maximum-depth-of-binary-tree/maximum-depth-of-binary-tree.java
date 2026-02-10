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
    public int maxDepth(TreeNode root) {
        int cnt=0;
        Queue<TreeNode>queue=new LinkedList<>();
        if(root==null) return cnt;

        queue.offer(root);
        while(!queue.isEmpty()){
            int s =queue.size();
            cnt++;
            for(int i=0;i<s;i++){
                 TreeNode curr=queue.poll();
                if(curr.left!=null)queue.offer(curr.left);
                if(curr.right!=null)queue.offer(curr.right);
                
            }
            

        }
        return cnt;
    }
}