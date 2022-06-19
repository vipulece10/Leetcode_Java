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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        if (head == null) {
            return null;
        }
        
        ListNode start = dummy;
        ListNode prevStart = null;
        
        for(int i = 0;i < left;i++){
            prevStart = start;
            start=start.next;
        }
       
       // System.out.print(end.val);
        
        
        ListNode curr = start;
        ListNode prev = prevStart;
        ListNode next = null;
        
        for(int i =left;i<=right;i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        prevStart.next = prev;
        start.next = curr;
        
        
        
        return dummy.next;
        
    }
}