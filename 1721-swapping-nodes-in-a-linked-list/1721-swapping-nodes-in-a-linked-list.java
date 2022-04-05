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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        ListNode slow = head;
        ListNode fast= head;
        
        for(int i=1;i<k;i++){
            fast=fast.next;
        }
        first=fast;
        
        while(first.next!=null){
            slow=slow.next;
            first=first.next;
        }
        
        int temp = slow.val;
        slow.val=fast.val;
        fast.val=temp;
        
        return head;
        
    }
}