/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
       HashSet <Node> pAncestors=new HashSet<>();
        while(p!=null){
            pAncestors.add(p);
            p=p.parent;
        }
        while(q!=null){
            if(pAncestors.contains(q)){
                return q;
            }
            q=q.parent;
        }
        return null;
    }
}