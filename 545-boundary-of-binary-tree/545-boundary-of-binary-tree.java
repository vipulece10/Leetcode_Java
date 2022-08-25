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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        if(isLeave(root) == false)
                res.add(root.val);
        addLeftBoundary(root,res);
        addLeaves(root,res);
        addRightBoundary(root,res);
        
        return res;
    }
    
    public void addLeftBoundary(TreeNode root,List<Integer> res){
        
        TreeNode curr = root.left;
        while(curr != null){
            if(isLeave(curr) == false)
                res.add(curr.val);
            if(curr.left != null) curr=curr.left;
            else curr = curr.right;
        }
    }
    
    public boolean isLeave(TreeNode node){
        if(node.left == null && node.right == null)
            return true;
        else 
            return false;
    }
    
    public void addLeaves(TreeNode root,List<Integer> res){
        if(root == null)
            return;
        if(isLeave(root))
            res.add(root.val);
        
        addLeaves(root.left,res);
        addLeaves(root.right,res);
    }
    
   public void addRightBoundary(TreeNode root,List<Integer> res){
        List<Integer> temp = new ArrayList<>();
        TreeNode curr = root.right;
        while(curr != null){
            if(isLeave(curr) == false)
                temp.add(curr.val);
            if(curr.right != null) curr=curr.right;
            else curr = curr.left;
        }
       
       for(int i = temp.size()-1;i>=0;i--){
           res.add(temp.get(i));
       }
    }
    
}