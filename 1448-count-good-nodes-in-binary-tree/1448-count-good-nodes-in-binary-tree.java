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
   int count;
    public int goodNodes(TreeNode root) {
         count = 0;
        dfs(root,Integer.MIN_VALUE);
        return count;
    }
    
    public void dfs(TreeNode root,int val){
        
        if(root == null)
            return;
       // System.out.println(root.val);
        if(root.val >= val){
          //  System.out.println("count" + count);
            count++;
            val = Math.max(root.val,val);
        }
        
        dfs(root.left,val);
        dfs(root.right,val);
    }
}