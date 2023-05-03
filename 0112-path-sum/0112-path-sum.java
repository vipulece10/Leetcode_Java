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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int count = 0;
        return dfs_helper(root,targetSum,count);
    }
    
    private boolean dfs_helper(TreeNode root,int targetSum,int count){
        if(root == null)
            return false;
        count += root.val;
        if(count == targetSum && root.left == null && root.right == null)
            return true;
        return dfs_helper(root.left,targetSum,count) || dfs_helper(root.right,targetSum,count);
    }
   
}