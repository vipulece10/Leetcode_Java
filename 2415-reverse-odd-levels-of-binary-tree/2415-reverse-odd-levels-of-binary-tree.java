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
    public TreeNode reverseOddLevels(TreeNode root) {
        int level =1;
        Queue<TreeNode> q =new LinkedList<>();
       
       // List<Integer> level_values  = new new ArrayList<>();
        
        q.add(root);
        while(!q.isEmpty()){
             List<TreeNode> level_nodes = new ArrayList<>();
            level++;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                level_nodes.add(node);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                
            }
            if(level % 2 !=0){
                int i = 0;
                int j = level_nodes.size() -1;
                while(i < j){
                    int temp = level_nodes.get(i).val;
                    level_nodes.get(i).val = level_nodes.get(j).val;
                    level_nodes.get(j).val = temp;
                    i++;
                    j--;
                    
                }               
            }
        }
        return root;
        
    }
}