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
            return " ";
        StringBuilder sb = new StringBuilder();
        postOrder(root,sb);
        return sb.toString();
    }
    
    private void postOrder(TreeNode root,StringBuilder sb){
        if(root == null)
            return;
        sb.append(root.val + " ");
        postOrder(root.left,sb);
        postOrder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(" ");
        constructTree(tokens,0,tokens.length - 1);
        return constructTree(tokens,0,tokens.length - 1);
    }
    
    private TreeNode constructTree(String [] tokens,int start,int end){
        if(start > end)
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(tokens[start]));
        int index;
        for(index = start;index <= end;index++){
            if(Integer.parseInt(tokens[index]) >Integer.parseInt(tokens[start])){
                break;
            }
        }
        root.left = constructTree(tokens,start+1,index-1);
        root.right = constructTree(tokens,index,end);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;