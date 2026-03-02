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
 class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node,int index){
        this.node=node;
        this.index=index;
    }
 }
class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {
Queue<Pair> q=new LinkedList<>();
int ans=0;
if(root==null) return 0;
q.offer(new Pair(root,0));
while(!q.isEmpty()){
     int size=q.size();
     int min=q.peek().index;
     int f=0;
     int l=0;
     for(int i=0;i<size;i++){
        int curr_id=q.peek().index-min;
        TreeNode node=q.peek().node;
        q.poll();

        if(i==0) f=curr_id;
        if(i==size-1) l=curr_id;
        if(node.left!=null){
            q.offer(new Pair(node.left,2*curr_id+1));
        }
        if(node.right!=null){
            q.offer(new Pair(node.right,2*curr_id+2));
        }
     }
     ans=Math.max(ans,l-f+1);
}
return ans;

    }
}