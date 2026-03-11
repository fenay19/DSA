/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root,p,q);
        return ans;
        
    }

    public int lca(TreeNode n,TreeNode p,TreeNode q){
           if(n== null){
            return 0;
           }

           int l=lca(n.left,p,q);
           int r=lca(n.right,p,q);
int self=0;

if(n==p||n==q){
    self=1;
}

int total=l+self+r;

if(total==2 && ans==null){
    ans=n;
}

return total;



    }
}