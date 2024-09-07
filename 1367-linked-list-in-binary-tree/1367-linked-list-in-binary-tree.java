/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    /*
    https://leetcode.com/problems/linked-list-in-binary-tree/discuss/1113360/Java-simple-and-easy-to-understand-solution-1-ms-faster-than-99.54.-clean-code-and-comment-added
    */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null && head ==null)
            return true;
        if(head !=null && root == null)
            return false;
        
        if(root.val == head.val){
            if(checkSubPath(head,root)){
                System.out.println(head.val + " " + root.val);
                return true;
            }
        }
        
        boolean leftSubPath = isSubPath(head,root.left);
        boolean rightSubPath = isSubPath(head,root.right);
        
        System.out.println(leftSubPath +" " + rightSubPath);
        return leftSubPath || rightSubPath;
    }
    
    public boolean checkSubPath(ListNode head,TreeNode node){
        
        if(head == null && node == null)
            return true;
        if(head != null && node == null)
            return false;
        if(head == null && node != null)
            return true;
        if(node != null && head.val != node.val)
            return false;
        
        boolean left = checkSubPath(head.next,node.left);
        boolean right = checkSubPath(head.next,node.right);
        
        return left || right;
    
    }
}