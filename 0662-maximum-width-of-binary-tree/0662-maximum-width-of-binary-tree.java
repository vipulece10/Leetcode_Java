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
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node,int index){
            this.node  = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int start = 0;
            int end = 0;
            for(int i=0;i<size;i++){
                Pair  pair = q.poll();
                int node_index = pair.index;
                if (i ==0){
                    start = node_index;
                }
               
                if (i == size - 1){
                    end = node_index;
                }
                    if(pair.node.left != null){
                        q.add(new Pair (pair.node.left,2*node_index));
                    }
                     if(pair.node.right != null){
                       q.add(new Pair (pair.node.right,2*node_index + 1));
                     }
                }
            maxWidth = Math.max(maxWidth,end - start + 1);
            }
        return maxWidth;
    }
}