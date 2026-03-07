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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> l=new ArrayList<>();
        if(root==null) return l;

        q.offer(root);
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer>lis=new ArrayList<>();
           
            for(int i=0;i<s;i++){
                 TreeNode n2=q.poll();
                if(n2.left!=null) q.offer(n2.left);
                if(n2.right!=null)q.offer(n2.right);
                lis.add(n2.val);
            }

            l.add(lis);
           
        }
         Collections.reverse(l);
        return l;
    }
    
}