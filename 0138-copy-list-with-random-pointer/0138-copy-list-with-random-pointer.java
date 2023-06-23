/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        HashMap <Node,Node> map = new HashMap<>();
        
       // map.put(null,null);
        Node curr = head;
        while(curr != null ){
            Node new_node = new Node(curr.val);
            map.put(curr,new_node);
            curr=curr.next;
        }
        
        Node start = head;
        while(start != null){
            Node copyList = map.get(start);
            copyList.next = map.get(start.next);
            copyList.random = map.get(start.random);
            start=start.next;
        }
        
        return map.get(head);
    }
}