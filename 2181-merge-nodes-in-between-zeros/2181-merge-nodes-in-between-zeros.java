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
    public ListNode mergeNodes(ListNode head) {
    
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        ListNode curr = head.next;
        int sum = 0;
        while(curr != null){
            sum += curr.val;
            if(curr.val == 0){
                ListNode node = new ListNode(sum);
                prev.next = node;
                prev = prev.next;
                sum = 0;
            }
            curr = curr.next;
        }
      return dummy.next;
    }
}