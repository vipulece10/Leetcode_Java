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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if(root == null)
            return null;
        
        // for(TreeNode node : nodes){
        //     if(node.val == root.val)
        //         return root;
        // }
        
        TreeNode left = lowestCommonAncestor(root.left,nodes);
        TreeNode right = lowestCommonAncestor(root.right,nodes);
        
        for(TreeNode node : nodes){
            if(node.val == root.val)
                return root;
        }
        
        if(left == null && right == null){
            return null;
        }
        if(left != null && right != null){
            return root;
        }
        if(left == null){
            return right;
        }
        else{
            return left;
        }
        //return null;
    }
}