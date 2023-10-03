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
class Tuple{
    TreeNode node;
    int x;
    int y;
    public Tuple(TreeNode node,int x, int y){
        this.node = node;
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/discuss/231125/Java-HashMap-and-TreeMap-and-PriorityQueue-Solution
        
        Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new HashMap<>();
        Queue<Tuple> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        if(root == null)
            return res;
        
        q.add(new Tuple(root,0,0));
        
        while(!q.isEmpty()){
            Tuple curr = q.poll();
            TreeNode currNode = curr.node;
            int x = curr.x;
            int y = curr.y;
            minX = Math.min(minX,x);
            maxX = Math.max(maxX,x);
            if(!map.containsKey(x)){
                map.put(x,new TreeMap<Integer,PriorityQueue<Integer>>());
            }
            if(map.get(x).get(y) == null){
                map.get(x).put(y,new PriorityQueue<Integer>());
            }
            map.get(x).get(y).add(currNode.val);
            if(currNode.left != null){
                q.add(new Tuple(currNode.left,x-1,y+1));
            }
            if(currNode.right != null){
                q.add(new Tuple(currNode.right,x+1,y+1));
            }
        }
        
       for(int i = minX;i<=maxX;i++){
           List<Integer> lst = new ArrayList<>();
           for(int key : map.get(i).keySet()){
               while(!map.get(i).get(key).isEmpty()){
                   lst.add(map.get(i).get(key).poll());
               }
           }
           res.add(lst);
       }
        return res;
    }
}