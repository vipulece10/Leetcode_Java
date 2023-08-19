/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        Queue<TreeNode> q  = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                sb.append("n ");
                continue;
            }
            
            sb.append(curr.val + " ");
            q.add(curr.left);
            q.add(curr.right);
        }
        
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 1 2 3 # # 4 5 # # # #
        if(data.equals(""))
            return null;
        //System.out.println(data);
        Queue<TreeNode> q = new LinkedList<>();
        String []  tokens = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        q.add(root);
        int i = 1;
        // for(String str : tokens){
        //     System.out.println(str);
        // }
        
        while(i < tokens.length){
            TreeNode curr = q.poll();
            if(!tokens[i].equals("n")){
                TreeNode node_left = new TreeNode(Integer.parseInt(tokens[i]));
                curr.left = node_left;
                q.add(node_left);
            }
            i++;
            if(!tokens[i].equals("n")){
                TreeNode node_right = new TreeNode(Integer.parseInt(tokens[i]));
                curr.right = node_right;
                q.add(node_right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));