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
    TreeNode dummy;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode curr=new TreeNode(-1);
        dummy = curr;
        dfs(root);
        return curr.right;
    }
    
    private void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.left);
        dummy.right=new TreeNode(root.val);
        dummy=dummy.right;
        dfs(root.right);
    }
}