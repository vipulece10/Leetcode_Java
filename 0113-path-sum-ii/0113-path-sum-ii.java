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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int currSum = 0;
        dfs_helper(root,ans,currSum,path,targetSum);
        return ans;
    }
    
    public void dfs_helper(TreeNode root,List<List<Integer>> ans,int currSum,List<Integer> path,int targetSum){
        if(root == null){
            return;
        }
        path.add(root.val);
        currSum += root.val;
        
        if(currSum == targetSum && root.left ==null && root.right == null){
            ans.add(new ArrayList<>(path));
           // ans.add(path);
           // return;
        }
        dfs_helper(root.left,ans,currSum,path,targetSum);
        dfs_helper(root.right,ans,currSum,path,targetSum);
        currSum -= root.val;
        path.remove(path.size() - 1);
    }
}