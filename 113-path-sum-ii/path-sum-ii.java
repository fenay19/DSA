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
    List<List<Integer>> arr=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        sum(root,0,targetSum,new ArrayList<>());
        return arr;
    }

    public void sum(TreeNode root,int sum,int t,List<Integer> list ){
        
        if(root==null) return;

        sum+=root.val;
        list.add(root.val);

        if(root.left==null && root.right==null){
            if(sum==t){
            arr.add(new ArrayList<>(list));
            
            
            }
        }

        sum(root.left,sum,t,list);
        sum(root.right,sum,t,list);
        list.remove(list.size()-1);
    }
}