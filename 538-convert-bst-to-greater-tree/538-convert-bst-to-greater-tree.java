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
    int res=0;
    public TreeNode convertBST(TreeNode root) {
      dfs(root);
      return root;  
    }
    
    private void dfs(TreeNode root){
        if(root == null)
            return;
        dfs(root.right);
        res=res+root.val;
        root.val=res;
        dfs(root.left);
    }
}