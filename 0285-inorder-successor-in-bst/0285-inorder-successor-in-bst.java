/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode curr = root;
        TreeNode next = null;
        while(curr != null){
            if(p.val < curr.val){
                next = curr;
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        return next;
    }
}