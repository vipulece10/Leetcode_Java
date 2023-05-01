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
     int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> lst = new ArrayList<>();
        pathSumHelper(root,targetSum,lst);
        return count;
    }
    private void pathSumHelper(TreeNode root,int targetSum,List<Integer>lst){
        if(root == null)
            return;
        lst.add(root.val);
        long sum  = 0;
        for(int i = lst.size()-1;i>=0;i--){
            sum += lst.get(i);
            if(sum == targetSum)
                count++;
        }
        pathSumHelper(root.left,targetSum,lst);
        pathSumHelper(root.right,targetSum,lst);
        lst.remove(lst.size() - 1);
    }
}