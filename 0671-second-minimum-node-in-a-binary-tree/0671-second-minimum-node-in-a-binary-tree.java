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
    int minimum = Integer.MAX_VALUE;
    int secondMinimum = Integer.MAX_VALUE;
    boolean found = false;
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        return found == true ? secondMinimum : -1;
    }
    private void dfs(TreeNode root){
        if(root == null)
            return;
        minimum = Math.min(root.val,minimum);
        if(root.val > minimum && root.val <= secondMinimum){
            found = true;
            secondMinimum = root.val;
        }
        dfs(root.left);
        
        dfs(root.right);
    }
}