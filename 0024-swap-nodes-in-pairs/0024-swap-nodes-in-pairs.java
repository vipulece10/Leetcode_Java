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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode curr = head;
        
        while(curr != null && curr.next != null){
            ListNode temp = curr.next.next;
            prev.next = curr.next;
            curr.next.next = curr;
            curr.next = temp;
            
            prev = curr;
            curr = curr.next;
        }
        
        return dummy.next;
        
    }
}