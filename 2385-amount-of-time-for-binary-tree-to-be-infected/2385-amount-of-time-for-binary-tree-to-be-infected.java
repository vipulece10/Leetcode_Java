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
    private void buildGraph(TreeNode root,int parent,HashMap<Integer,List<Integer>> map){
        if (root == null)
            return;
        if(parent != -1){
            if(!map.containsKey(root.val)){
                map.put(root.val,new ArrayList<>());
                map.get(root.val).add(parent);
            }else{
                map.get(root.val).add(parent);
            }
            if(!map.containsKey(parent)){
                map.put(parent,new ArrayList<>());
                map.get(parent).add(root.val);
            }else{
                map.get(parent).add(root.val);
            }
        }
        buildGraph(root.left,root.val,map);
        buildGraph(root.right,root.val,map);
    }

    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        buildGraph(root,-1,map);
        Queue <Integer> q = new LinkedList<>();
        Set <Integer> visited = new HashSet<>();
        q.add(start);
         visited.add(start);
        int ans = 0;
        for(int key : map.keySet()){
            System.out.println(key );
        }
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr = q.poll();
                if(!map.containsKey(curr))
                    continue;
                for(int next : map.get(curr)){
                    if(!visited.contains(next)){
                        q.add(next);
                        visited.add(next);
                    }
                }
            }
            ans++;
        }
        return ans - 1;
    }

}