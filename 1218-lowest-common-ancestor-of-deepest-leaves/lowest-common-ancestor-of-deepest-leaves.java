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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).n;

    }

    class pair{
        TreeNode n;
        int depth;
        pair(TreeNode n,int depth){
            this.n=n;
            this.depth=depth;
        }


    }

    public pair dfs(TreeNode rt){


        if(rt==null) return new pair(rt,0);

        pair l=dfs(rt.left);
        pair r=dfs(rt.right);

        if(l.depth>r.depth){

            return new pair(l.n,l.depth+1);
        }
        if(l.depth<r.depth){
            return new pair(r.n,r.depth+1);
        }


        return new pair(rt,l.depth+1);

    }

}