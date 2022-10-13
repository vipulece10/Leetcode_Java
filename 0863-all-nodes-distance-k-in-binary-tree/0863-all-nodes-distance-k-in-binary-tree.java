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
    Map<TreeNode,TreeNode> map_parent = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    Set<TreeNode> vis = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root,null,map_parent);
        dfsKnode(target,k,res);
        return res;
        
    }
    public void findParent(TreeNode root,TreeNode parent,Map<TreeNode,TreeNode> map_parent){
        if(root == null)
            return;
        map_parent.put(root,parent);
        findParent(root.left,root,map_parent);
        findParent(root.right,root,map_parent);
    }
    
    public void dfsKnode(TreeNode root,int k, List<Integer>res){
        if(root == null || vis.contains(root))
            return;
        if(k == 0){
            res.add(root.val);
            return;
        }
        vis.add(root);
        dfsKnode(root.left,k-1,res);
        dfsKnode(root.right,k-1,res);
        dfsKnode(map_parent.get(root),k-1,res);
    }
}