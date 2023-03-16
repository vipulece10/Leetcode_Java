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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        boolean nullnode = false;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            //System.out.println(node.val);
            if(node == null)
                nullnode = true;
            else{
                if(nullnode)
                    return false;
            q.add(node.left);
            q.add(node.right);
            }
        }
        return true;
    }
}