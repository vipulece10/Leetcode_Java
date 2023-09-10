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
    //https://youtu.be/X0oXMdtUDwo
    
    public class Node{
        int size;
        int max;
        int min;
        
        public Node(int size,int max,int min){
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }
    private Node largestBSTSubtreeHelper(TreeNode root){
        if(root == null)
            return new Node(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        
        Node leftNode = largestBSTSubtreeHelper(root.left);
        Node rightNode = largestBSTSubtreeHelper(root.right);
        
        if(leftNode.max < root.val && root.val < rightNode.min)
        {
            return new Node(leftNode.size + rightNode.size+1,Math.max(root.val,rightNode.max),Math.min(root.val,leftNode.min));
        }
        return new Node(Math.max(leftNode.size,rightNode.size),Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    
    public int largestBSTSubtree(TreeNode root) {
        
        return largestBSTSubtreeHelper(root).size;
        
    }
}