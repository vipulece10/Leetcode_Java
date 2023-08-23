/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b)-> a-b);
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        
        for(ListNode l : lists){
            while(l != null){
                pq.add(l.val);
                l= l.next;
            }
        }
        
        while(pq.size()>0){
            ListNode temp = new ListNode(pq.poll());
            head.next = temp;
            head = head.next;
        }
        
        return dummy.next;
    }
}