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
    private HashMap<Integer,Integer> map = new HashMap<>();
    private int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        subTreeSum(root);
        List<Integer> res = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == maxFreq)
                res.add(key);
        }
        int [] finalResult = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            finalResult[i] = res.get(i);
        }
        return finalResult;
    }
    private int subTreeSum(TreeNode root){
        if(root == null)
            return 0;
        
        int left = subTreeSum(root.left);
        int right = subTreeSum(root.right);
        int total = left + right + root.val;
        map.put(total,map.getOrDefault(total,0)+1);
        maxFreq = Math.max(maxFreq,map.get(total));
        return total;
    }
}