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
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        //find the middle element of the list
        ListNode slow = head;
        ListNode fast = head;
        ListNode start = head;
        while(fast.next !=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
       // ListNode middle = slow.next;
        //reverse from the middle element
        slow.next = reverseList(slow.next);
        ListNode end = slow.next;
        ListNode middle = slow.next;
        slow.next = null;
        while(end !=null){
            ListNode first_half = start.next;
            ListNode second_half = end.next;
            start.next = end;
            end.next = first_half;
            start = first_half;
            end = second_half;
        }
        
      //  return head;
    }
}