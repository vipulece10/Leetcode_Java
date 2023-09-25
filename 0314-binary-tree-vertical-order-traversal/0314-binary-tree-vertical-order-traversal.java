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
    //https://leetcode.com/problems/binary-tree-vertical-order-traversal/discuss/736273/Java-BFS-and-DFS-solutions
    class Tuple{
        int vertical;
        TreeNode node;
      //  int level;
        public Tuple(int vertical,TreeNode node){
            this.vertical = vertical;
            this.node = node;
          //  this.level = level;
            
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer,List<Integer>> tmap = new TreeMap<>();
        Queue<Tuple>q=new LinkedList<>();
        if (root == null)
            return ans;
        q.add(new Tuple(0,root));
        
        while(!q.isEmpty()){
            Tuple t = q.poll();
            int currVertical =t.vertical;
            TreeNode currNode = t.node;
           if(!tmap.containsKey(currVertical)){
               tmap.put(currVertical,new ArrayList<>());
           }
            List list = tmap.get(currVertical);
            list.add(currNode.val);
            tmap.put(currVertical,list);
            if(currNode.left != null){
                q.add(new Tuple(currVertical - 1,currNode.left));
            }
            if(currNode.right != null){
                q.add(new Tuple(currVertical + 1,currNode.right));
            }
            
        }
        for(List<Integer> lst : tmap.values()){
            ans.add(lst);
        }
        return ans;
    }
}