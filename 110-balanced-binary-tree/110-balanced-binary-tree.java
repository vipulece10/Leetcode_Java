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
    public boolean isBalanced(TreeNode root) {
        int val = dfs(root);
        if(val == -1)
            return false;
        return true;
    }
    
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left=dfs(root.left);
        int right = dfs(root.right);
        
        if(left == -1 || right == -1 || Math.abs(left-right) > 1)
            return -1;
        
        return 1 + Math.max(left,right);
    }
}