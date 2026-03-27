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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> imap=new HashMap<Integer,Integer>();

        for(int i=0;i<inorder.length;i++){
            imap.put(inorder[i],i);
        }
        return tre(inorder,0,inorder.length-1,postorder,0,postorder.length-1,imap);
    }

    public TreeNode tre(int []inorder,int instart,int inend,int []postorder,int pstart,int pend,Map<Integer,Integer>imap){

if(instart>inend || pstart>pend) return null;

TreeNode root=new TreeNode(postorder[pend]);

int inroot=imap.get(root.val);
int lsum=inroot-instart;

root.left=tre(inorder,instart,inroot-1,postorder,pstart,pstart+lsum-1,imap);
root.right=tre(inorder,inroot+1,inend,postorder,pstart+lsum,pend-1,imap);


return root;
    }
}