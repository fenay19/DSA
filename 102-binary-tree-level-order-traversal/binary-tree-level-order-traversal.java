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
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res=new ArrayList<>();
      Queue<TreeNode> queue=new LinkedList<>();
      if(root==null) return res;
      queue.offer(root);
      while(!queue.isEmpty()){
       int s=queue.size();
       List<Integer> subres=new ArrayList<>();

      for(int i=0;i<s;i++){
        if(queue.peek().left!=null)queue.offer(queue.peek().left);
         if(queue.peek().right!=null)queue.offer(queue.peek().right);
         subres.add(queue.poll().val);
      }
      res.add(subres);
      }
      return res;
    }
}