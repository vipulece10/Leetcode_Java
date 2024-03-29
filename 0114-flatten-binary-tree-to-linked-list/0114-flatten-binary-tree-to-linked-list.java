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
                    1
                       2
                    3       4
                                5
                                    6
 
 
 */
class Solution {
    public void flatten(TreeNode root) {
       if(root == null)
           return;
        
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null){
        TreeNode curr = root.left;
        while(curr.right != null){
            curr=curr.right;
        }
        curr.right = root.right;
        root.right = root.left;
        root.left = null;
        }
    }
}