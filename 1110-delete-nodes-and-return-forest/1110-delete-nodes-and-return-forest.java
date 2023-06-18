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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        List<TreeNode> lst = new ArrayList<>();
        for(int i = 0;i<to_delete.length;i++){
            set.add(to_delete[i]);
        }
        if(!set.contains(root.val))
            lst.add(root);
        dfs_helper(root,set,lst);
        return lst;
    }
    
    public void dfs_helper(TreeNode root,Set<Integer> set,List<TreeNode> lst){
        if(root == null)
            return;
        
        dfs_helper(root.left,set,lst);
        dfs_helper(root.right,set,lst);
        if(root.left != null && set.contains(root.left.val)){
                root.left = null;
        }
        if(root.right != null && set.contains(root.right.val)){
                root.right = null;
        }
         if (set.contains(root.val)) {
            if (root.left != null) lst.add(root.left);
            if (root.right != null) lst.add(root.right);
        }
        }
    }
//}