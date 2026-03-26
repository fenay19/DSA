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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer>imap=new HashMap<Integer,Integer>();

        for(int i=0;i<inorder.length;i++){
            imap.put(inorder[i],i);
        }
        TreeNode root=tre(preorder,0,preorder.length-1,inorder,0,inorder.length-1,imap);

        return root;
    }

    public TreeNode tre(int[] preorder,int pres,int preend,int[]inorder,int instart,int inend,Map<Integer,Integer> inmap){


if(pres>preend || instart>inend) return null;
TreeNode root= new TreeNode(preorder[pres]);

int inroot=inmap.get(root.val);
int inleft=inroot-instart;

root.left=tre(preorder,pres+1,pres+inleft,inorder,instart,inroot-1,inmap);
root.right=tre(preorder,pres+inleft+1,preend,inorder,inroot+1,inend,inmap);
return root;
    }
}